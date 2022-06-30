package com.example.jpa_study.repository;

import com.example.jpa_study.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/06/30
 */

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
