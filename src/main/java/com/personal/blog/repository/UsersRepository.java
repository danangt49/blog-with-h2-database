package com.personal.blog.repository;

import com.personal.blog.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersRepository extends JpaRepository<Users, Long> {
    @Query("SELECT u FROM Users AS u WHERE u.username = ?1")
    Users findByUsername(String username);
}