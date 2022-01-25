package com.mihalkovich.adminservice.service;

import com.mihalkovich.adminservice.dto.GroupDto;
import com.mihalkovich.adminservice.entity.Group;
import com.mihalkovich.adminservice.mapper.GroupMapper;
import com.mihalkovich.adminservice.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<GroupDto> getGroups(){
        return groupRepository.findAll().stream()
                .map(groupMapper::groupToGroupDto)
                .collect(Collectors.toList());
    }

    public GroupDto saveGroup(GroupDto groupDto){

        Group group = new Group();
        group.setCourse(groupDto.getCourse());
        group.setGroup(groupDto.getGroup());
        groupRepository.save(group);

        return groupDto;
    }

    public Group getGroup(String course, String groupName){
        return groupRepository.findGroupByCourseAndGroup(course, groupName).orElseThrow();
    }

    public GroupDto deleteGroup(GroupDto groupDto){
        Group group = getGroup(groupDto.getCourse(), groupDto.getGroup());
        groupRepository.delete(group);

        return groupDto;
    }

    public GroupDto updateGroup(GroupDto groupDtoBefore, GroupDto groupDtoAfter) {
        Group group = getGroup(groupDtoBefore.getCourse(), groupDtoBefore.getGroup());
        group.setCourse(groupDtoAfter.getCourse());
        group.setGroup(groupDtoAfter.getGroup());
        groupRepository.save(group);

        return groupDtoAfter;
    }
}