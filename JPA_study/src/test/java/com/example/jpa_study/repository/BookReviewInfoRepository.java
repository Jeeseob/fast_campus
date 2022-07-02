package com.example.jpa_study.repository;

import com.example.jpa_study.domain.BookReviewInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/07/01
 */

@Repository
public interface BookReviewInfoRepository extends JpaRepository<BookReviewInfo, Long> {
}
