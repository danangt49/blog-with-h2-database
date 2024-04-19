package com.personal.blog;

import com.personal.blog.config.security.JwtProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class JwtProviderTest {

    @Autowired
    private JwtProvider jwtProvider;

    @Test
    public void testGenerateToken() {
        UserDetails userDetails = new User(
                "user",
                "password",
                Collections.singletonList(new SimpleGrantedAuthority("USER"))
        );

        String token = jwtProvider.generateToken(userDetails);
        assertNotNull(token);
        System.out.println(token);
    }
}
