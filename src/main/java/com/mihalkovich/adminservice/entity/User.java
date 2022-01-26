package com.mihalkovich.adminservice.entity;

import com.mihalkovich.adminservice.enums.Role;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, updatable = false)
    @NotBlank
    @Size(min = 6, max = 20)
    private String username;

    @Column
    @NotBlank
    @Size(min = 6,max = 20)
    private String password;

    @Column
    private Role role;
}
