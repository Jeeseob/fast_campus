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
}
