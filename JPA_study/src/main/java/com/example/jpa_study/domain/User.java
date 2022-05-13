package com.example.jpa_study.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/05/10
 */

@Entity
@Data // Getter + Setter + ToString + RequiredArgsConstructor + EqualsAndHashCode
@NoArgsConstructor // JPA에서는 NoArgsConstructor가 필수적으로 필요하다.
@AllArgsConstructor
@Builder // 객체 생성 후 Field값을 제공
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
}
