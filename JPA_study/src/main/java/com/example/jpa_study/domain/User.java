package com.example.jpa_study.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/05/10
 */

/**
 * NoArgsConstructor : JPA에서는 NoArgsConstructor가 필수적으로 필요하다.
 * Builder : 객체 생성 후 Field값을 제공
 */

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Address> addresses;
}
