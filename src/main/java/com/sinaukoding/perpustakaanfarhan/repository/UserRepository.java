package com.sinaukoding.perpustakaanfarhan.repository;

import com.sinaukoding.perpustakaanfarhan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
