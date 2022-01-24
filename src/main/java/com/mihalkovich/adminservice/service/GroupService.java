package com.mihalkovich.adminservice.service;

import com.mihalkovich.adminservice.dto.GroupDTO;
import com.mihalkovich.adminservice.entity.Group;
import com.mihalkovich.adminservice.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public List<Group> getGroups(){
        return groupRepository.findAll();
    }

    public Group saveGroup(GroupDTO groupDTO){

        Group group = new Group();
        group.setCourse(groupDTO.getCourse());
        group.setGroup(groupDTO.getGroup());

        return groupRepository.save(group);
    }

    public Group getGroup(String course, String groupName){
        return groupRepository.findGroupByCourseAndGroup(course, groupName).orElseThrow();
    }

    public Group deleteGroup(GroupDTO groupDTO){
        Group group = getGroup(groupDTO.getCourse(), groupDTO.getGroup());
        groupRepository.delete(group);

        return group;
    }

    public Group updateGroup(GroupDTO groupDTOBefore, GroupDTO groupDTOAfter) {
        Group group = getGroup(groupDTOBefore.getCourse(), groupDTOBefore.getGroup());
        group.setCourse(groupDTOAfter.getCourse());
        group.setGroup(groupDTOAfter.getGroup());

        return groupRepository.save(group);
    }
}