package com.sinaukoding.perpustakaanfarhan.entity.dto;

import com.sinaukoding.perpustakaanfarhan.entity.mapping.UserMapping;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    public static UserMapping instance;
    private Long id_user;

    private String username;

    private String password;

    private String email;

    private String role;
}