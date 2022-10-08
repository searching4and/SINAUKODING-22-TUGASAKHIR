package com.sinaukoding.perpustakaanfarhan.service.impl;

import com.sinaukoding.perpustakaanfarhan.entity.dto.UserDTO;
import com.sinaukoding.perpustakaanfarhan.entity.mapping.UserMapping;
import com.sinaukoding.perpustakaanfarhan.repository.UserRepository;
import com.sinaukoding.perpustakaanfarhan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDTO findByUsername(String username) {
        return UserMapping.instance.toDto(repository.findByUsername(username));
    }

    @Override
    public List<UserDTO> getAllData() {
        return UserMapping.instance.toListDto(repository.findAll());
    }
}