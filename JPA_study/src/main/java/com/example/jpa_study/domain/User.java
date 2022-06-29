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
@Table(indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})}) // 여러개의 column의 조합이 유니크 해야할때
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Column(updatable = false) // 단독적으로 column이 유니크할때
    private LocalDateTime createdAt;

    @Column(insertable = false)
    private LocalDateTime updatedAt;

    @Transient // DB에 저장하지 않고, 객체와 생명주기를 같이한다.
    private String testData;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> addresses;
}
