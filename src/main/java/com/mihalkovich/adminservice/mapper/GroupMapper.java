package com.mihalkovich.adminservice.mapper;

import com.mihalkovich.adminservice.dto.GroupDto;
import com.mihalkovich.adminservice.entity.Group;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroupMapper {

    GroupDto groupToGroupDto(Group group);
}
