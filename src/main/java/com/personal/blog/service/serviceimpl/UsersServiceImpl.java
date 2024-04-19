package com.personal.blog.service.serviceimpl;

import com.personal.blog.repository.UsersRepository;
import com.personal.blog.service.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    @Override
    public UserDetails findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }
}
