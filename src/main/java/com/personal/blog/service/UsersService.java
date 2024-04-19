package com.personal.blog.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UsersService {
    UserDetails findByUsername(String username);
}
