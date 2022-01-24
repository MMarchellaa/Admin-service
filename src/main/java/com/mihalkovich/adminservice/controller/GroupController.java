package com.mihalkovich.adminservice.controller;

import com.mihalkovich.adminservice.dto.GroupDTO;
import com.mihalkovich.adminservice.facade.GroupFacade;
import com.mihalkovich.adminservice.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GroupController {

    @Autowired
    GroupService groupService;
    @Autowired
    GroupFacade groupFacade;

    @GetMapping("group/all")
    public ResponseEntity<List<GroupDTO>> getAllGroups(){
        List<GroupDTO> allGroupsDTO = groupService.getGroups()
                .stream()
                .map(groupFacade::groupToGroupDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(allGroupsDTO, HttpStatus.OK);
    }

    @PostMapping("group/save")
    public ResponseEntity<GroupDTO> saveGroup(@RequestBody GroupDTO groupDTO){
        GroupDTO group = groupFacade.groupToGroupDTO(groupService.saveGroup(groupDTO));

        return new ResponseEntity<>(group, HttpStatus.OK);
    }

    @PostMapping("group/delete")
    public ResponseEntity<GroupDTO> deleteGroup(@RequestBody GroupDTO groupDTO){
        GroupDTO group = groupFacade.groupToGroupDTO(groupService.deleteGroup(groupDTO));

        return new ResponseEntity<>(group, HttpStatus.OK);
    }

    @PostMapping("group/update")
    public ResponseEntity<GroupDTO> updateGroup(@RequestBody GroupDTO groupDTOBefore, @RequestBody GroupDTO groupDTOAfter){
        GroupDTO group = groupFacade.groupToGroupDTO(groupService.updateGroup(groupDTOBefore, groupDTOAfter));

        return new ResponseEntity<>(group, HttpStatus.OK);
    }
}