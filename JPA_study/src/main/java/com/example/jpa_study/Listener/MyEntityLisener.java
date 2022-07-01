package com.example.jpa_study.Listener;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/06/30
 */

public class MyEntityLisener {
    @PrePersist
    public void prePersist(Object object) {
        if (object instanceof Auditable) {
            ((Auditable) object).setCreatedAt(LocalDateTime.now());
            ((Auditable) object).setUpdatedAt(LocalDateTime.now());
        }
    }

    @PreUpdate
    public void preUpdate(Object obejct) {
        if (obejct instanceof Auditable) {
            ((Auditable) obejct).setUpdatedAt(LocalDateTime.now());
        }
    }
}
