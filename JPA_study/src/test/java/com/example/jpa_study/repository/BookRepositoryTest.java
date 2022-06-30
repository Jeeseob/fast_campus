package com.example.jpa_study.repository;

import com.example.jpa_study.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/06/30
 */

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void BookTest() {
        Book book = new Book();
        book.setName("Jpa");
        book.setAuthor("fastcampus");

        bookRepository.save(book);
        System.out.println(bookRepository.findAll());
    }

}