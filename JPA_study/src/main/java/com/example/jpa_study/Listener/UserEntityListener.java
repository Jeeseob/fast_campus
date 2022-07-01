package com.example.jpa_study.Listener;

import com.example.jpa_study.domain.User;
import com.example.jpa_study.domain.UserHistory;
import com.example.jpa_study.repository.UserHistoryRepository;
import com.example.jpa_study.support.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/07/01
 */

public class UserEntityListener {
    @PrePersist
    @PreUpdate
    public void prePersistAndPreUpdate(Object o) {
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);
        User user = (User)o;

        UserHistory userHistory = new UserHistory();
        userHistory.setUserId(user.getId());
        userHistory.setName(user.getName());
        userHistory.setEmail(user.getEmail());

        userHistoryRepository.save(userHistory);
    }
}
