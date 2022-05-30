package com.example.jpa_study.repository;

import com.example.jpa_study.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/05/13
 */

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    List<User> findByName(String name);

    User findByEmail(String email);

    User getByEmail(String email);

    User readByEmail(String email);

    User queryByEmail(String email);

    User searchByEmail(String email);

    User streamByEmail(String email);

    User findUserByEmail(String email);


    List<User> findTop1ByName(String name);

    List<User> findFirst1ByName(String name);

    // Query 2

    List<User> findByEmailAndName(String Email, String name);
}
