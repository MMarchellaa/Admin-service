package com.mihalkovich.adminservice.facade;

import com.mihalkovich.adminservice.dto.GroupDTO;
import com.mihalkovich.adminservice.entity.Group;
import org.springframework.stereotype.Component;

@Component
public class GroupFacade {

    public GroupDTO groupToGroupDTO(Group group){
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setGroup(group.getGroup());
        groupDTO.setCourse(group.getCourse());

        return groupDTO;
    }
}
