package com.sinaukoding.perpustakaanfarhan.service.impl;

import com.sinaukoding.perpustakaanfarhan.entity.dto.PetugasDTO;
import com.sinaukoding.perpustakaanfarhan.entity.dto.UserDTO;
import com.sinaukoding.perpustakaanfarhan.entity.mapping.PetugasMapping;
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
    public UserDTO findById(Long id) {
        return UserMapping.instance.toDto(repository.findById(id).orElse(null));
    }

    @Override
    public List<UserDTO> getAllData() {
        return UserMapping.instance.toListDto(repository.findAll());
    }
}