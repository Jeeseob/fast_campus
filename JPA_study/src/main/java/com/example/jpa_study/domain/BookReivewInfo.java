package com.example.jpa_study.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/07/01
 */

@Entity
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public class BookReivewInfo extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    private Long bookId;

    private float averageReviewScore;

    private int reviewCount;

}
