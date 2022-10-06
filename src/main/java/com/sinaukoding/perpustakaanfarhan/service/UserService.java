package com.sinaukoding.perpustakaanfarhan.service;

import com.sinaukoding.perpustakaanfarhan.entity.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO findByUsername(String username);

    List<UserDTO> getAllData();
}
