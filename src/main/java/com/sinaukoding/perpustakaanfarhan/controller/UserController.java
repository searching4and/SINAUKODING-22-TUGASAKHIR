package com.sinaukoding.perpustakaanfarhan.controller;

import com.sinaukoding.perpustakaanfarhan.common.Response;
import com.sinaukoding.perpustakaanfarhan.entity.dto.UserDTO;
import com.sinaukoding.perpustakaanfarhan.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImpl service;

    @GetMapping("/find-all")
    public Response getAllData(){
        List<UserDTO> data = service.getAllData();
        return new Response(data, "Menampilkan Data User", data.size(), HttpStatus.OK);
    }

    @GetMapping("/find-by-username")
    public Response findByUsername(@RequestParam String username){
        return new Response(service.findByUsername(username), "Menampilkan Data", HttpStatus.OK);
    }
}