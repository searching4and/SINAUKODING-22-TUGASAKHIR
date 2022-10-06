package com.sinaukoding.perpustakaanfarhan.service;

import com.sinaukoding.perpustakaanfarhan.entity.dto.AuthenticationDTO;
import com.sinaukoding.perpustakaanfarhan.entity.dto.ResponseAuthDTO;
import com.sinaukoding.perpustakaanfarhan.entity.dto.UserDTO;

public interface AuthService {
    ResponseAuthDTO register(UserDTO data);

    ResponseAuthDTO login(AuthenticationDTO data);
}