package com.example.jpa_study.repository;

import com.example.jpa_study.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/05/13
 */

@SpringBootTest // Spring Context를 Load하여 Test하겠다는 의미
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() {
        /**
         * Test시에, 특정 ArrayList를 만들면, 코드가 복잡해지기 때문에, Lists.newArrayList를 사용한다.
         */
        List<User> users = userRepository.findAllById(Lists.newArrayList(1L, 3L, 5L));
        users.forEach(System.out::println);
    }
}