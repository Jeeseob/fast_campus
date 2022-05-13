package com.example.jpa_study.repository;

import com.example.jpa_study.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
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
    @Transactional // 세션 유지
    void crud() {
        User user = userRepository.getOne(1L);
        System.out.println(user);

        User user3 = userRepository.findById(1L).orElse(null);
        System.out.println(user3);

        User user1 = new User("jack", "jack@gmail.com");
        User user2 = new User("steve", "seteve@gamil.com");

        userRepository.saveAll(Lists.newArrayList(user1, user2));
        List<User> users = userRepository.findAll();
    }
}