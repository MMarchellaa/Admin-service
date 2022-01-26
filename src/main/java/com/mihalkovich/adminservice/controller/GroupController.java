package com.mihalkovich.adminservice.controller;

import com.mihalkovich.adminservice.dto.GroupDto;
import com.mihalkovich.adminservice.service.GroupService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/group")
@Api
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    @ApiOperation(value = "get all groups")
    public List<GroupDto> getAllGroups(){

        return groupService.getGroups();
    }

    @PostMapping
    @ApiOperation(value = "save group")
    public GroupDto saveGroup(@RequestBody @Valid GroupDto groupDto){

        return groupService.saveGroup(groupDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete group")
    public GroupDto deleteGroup(@PathVariable String id){

        return groupService.deleteGroup(id);
    }

    @PutMapping
    @ApiOperation(value = "update group")
    public GroupDto updateGroup(@RequestBody @Valid GroupDto groupDto){

        return groupService.updateGroup(groupDto);
    }
}
