package com.example.jpa_study.domain;

import org.junit.jupiter.api.Test;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/05/10
 */
class UserTest {

    @Test
    void testTest() {
        User user = new User();
        user.setEmail("jeeseob5761@gmail.com");
        user.setName("Jeeseob");

        User user2 = User.builder()
                .name("Jeeseob")
                .email("jeeseob5761@gmail.com")
                .build();

        System.out.println(user.toString());
    }
}