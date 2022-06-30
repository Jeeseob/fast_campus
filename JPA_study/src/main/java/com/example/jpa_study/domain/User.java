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

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@EntityListeners(value = MyEntityLisener.class)
@Table(indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})}) // 여러개의 column의 조합이 유니크 해야할때
public class User implements Auditable{
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    // Enum의 값을 꼭 String형태로 변경해야한다. 그렇지 않으면 기본적으로 0,1,2 등 숫자 순서대로 저장되어 spring에서 매칭을 시키는데 type들의 위치가 변경되면 나중에 문제가 발생할 수 있다.
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @NonNull
    private String email;

    @Column(updatable = false) // 단독적으로 column이 유니크할때
    private LocalDateTime createdAt;

    //@Column(insertable = false)
    private LocalDateTime updatedAt;

    @Transient // DB에 저장하지 않고, 객체와 생명주기를 같이한다.
    private String testData;


//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> addresses;



//    @PrePersist // insert 전
//    public void prePersist() {
//        System.out.println(">>> prePersist");
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    public void preUpdate() {
//        System.out.println(">>> preUpdate");
//        this.updatedAt = LocalDateTime.now();
//    }

//    @PostPersist
//    public void postPresist() {
//        System.out.println(">>> postPersist");

//    }
//
//    @PostUpdate
//    public void postUpdate(){
//        System.out.println(">>> postUpdate");
//    }
//
//    @PreRemove
//    public void preRemove(){
//        System.out.println(">>> preRemove");
//    }
//
//    @PostRemove
//    public void postRemove(){
//        System.out.println(">>> postRemove");
//    }
//
//    @PostLoad // Select 이후, preLoad는 없다
//    public void postLoad(){
//        System.out.println(">>> postLoad");
//    }
}
