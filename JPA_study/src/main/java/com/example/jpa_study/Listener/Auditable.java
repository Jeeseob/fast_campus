package com.example.jpa_study.Listener;

import java.time.LocalDateTime;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/06/30
 */
public interface Auditable {
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();

    void setCreatedAt(LocalDateTime createdAt);
    void setUpdatedAt(LocalDateTime updatedAt);
}
