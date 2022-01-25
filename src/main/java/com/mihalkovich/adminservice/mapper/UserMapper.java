package com.mihalkovich.adminservice.mapper;

import com.mihalkovich.adminservice.dto.UserDto;
import com.mihalkovich.adminservice.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userToUserDto(User user);
}
