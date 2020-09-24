package com.beignet.springboot;

import com.beignet.springboot.jpa.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JPQLTest {
    @Autowired
    UserRepository userRepository;

    
}
