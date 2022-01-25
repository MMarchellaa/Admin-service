package com.mihalkovich.adminservice.controller;

import com.mihalkovich.adminservice.dto.GroupDto;
import com.mihalkovich.adminservice.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("group")
    public List<GroupDto> getAllGroups(){

        return groupService.getGroups();
    }

    @PostMapping("group")
    public GroupDto saveGroup(@RequestBody GroupDto groupDto){

        return groupService.saveGroup(groupDto);
    }

    @DeleteMapping("group/{id}")
    public GroupDto deleteGroup(@PathVariable String id){

        return groupService.deleteGroup(id);
    }

    @PutMapping("group/{id}")
    public GroupDto updateGroup(@PathVariable String id, @RequestBody GroupDto groupDto){

        return groupService.updateGroup(id, groupDto);
    }
}
