package com.mihalkovich.adminservice.service;

import com.mihalkovich.adminservice.dto.GroupDto;
import com.mihalkovich.adminservice.entity.Group;
import com.mihalkovich.adminservice.mapper.GroupMapper;
import com.mihalkovich.adminservice.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    private final GroupMapper groupMapper;

    @Autowired
    public GroupService(GroupRepository groupRepository, GroupMapper groupMapper) {
        this.groupRepository = groupRepository;
        this.groupMapper = groupMapper;
    }

    @Cacheable(value = "groups")
    public List<GroupDto> getGroups(){
        System.out.println("access the db");
        return groupRepository.findAll().stream()
                .map(groupMapper::toDto)
                .collect(Collectors.toList());
    }

    @CacheEvict(value = "groups", allEntries = true)
    public GroupDto saveGroup(GroupDto groupDto){
        System.out.println("access the db");
        System.out.println();
        return groupMapper.toDto(groupRepository.save(groupMapper.toGroup(groupDto)));
    }

    public Group getGroup(String course, String groupName){
        return groupRepository.findGroupByCourseAndGroup(course, groupName).orElseThrow();
    }

    @CacheEvict(value = "groups", allEntries = true)
    public GroupDto deleteGroup(String id){
        System.out.println("access the db");
        Group group = groupRepository.findGroupById(Long.parseLong(id));
        groupRepository.delete(group);

        return groupMapper.toDto(group);
    }

    @CacheEvict(value = "groups", allEntries = true)
    public GroupDto updateGroup(GroupDto groupDto) {
        System.out.println("access the db");
        Group group = groupRepository.findGroupById(groupDto.getId());
        group.setCourse(groupDto.getCourse());
        group.setGroup(groupDto.getGroup());
        groupRepository.save(group);

        return groupMapper.toDto(group);
    }
}
