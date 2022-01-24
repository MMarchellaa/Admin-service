package com.mihalkovich.adminservice.facade;

import com.mihalkovich.adminservice.dto.UserDTO;
import com.mihalkovich.adminservice.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserFacade {

    public UserDTO userToUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setRole(user.getRole());

        return userDTO;
    }
}
