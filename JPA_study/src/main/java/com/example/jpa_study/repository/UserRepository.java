package com.example.jpa_study.repository;

import com.example.jpa_study.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/05/13
 */

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    List<User> findByName(String name);

    // Is나 Equal은 큰 의미없다. 하지만 코드 가독성에 도움을 준다.
    List<User> findUserByName(String name);
    List<User> findUSerByNameIs(String name);
    List<User> findUserByNameEquals(String name);

    User findByEmail(String email);

    User getByEmail(String email);

    User readByEmail(String email);

    User queryByEmail(String email);

    User searchByEmail(String email);

    User streamByEmail(String email);

    User findUserByEmail(String email);


    List<User> findTop1ByName(String name);

    List<User> findLast1ByName(String name); // Id기준 마지막 데이터.. -> 정상적으로 동작하지 않음.

    List<User> findTop1ByNameOrderByIdDesc(String name); // Id를 기준으로 오름차순정렬 이후 가장 높은것


    List<User> findFirst1ByName(String name);

    // Query 2

    List<User> findByEmailAndName(String Email, String name);

    List<User> findByEmailOrName(String Email, String name);

    List<User> findByCreatedAtAfter(LocalDateTime time);

    List<User> findByIdAfter(Long id);

    List<User> findByCreatedAtGreaterThan(LocalDateTime yesterday);

    List<User> findByCreatedAtBetween(LocalDateTime yesterday, LocalDateTime tomorrow);

    List<User> findByIdBetween(Long id1, Long id2);

    //Query 3

    List<User> findByIdIsNotNull();

    List<User> findByAddressesIsNotEmpty();

    List<User> findByNameIn(List<String> names);

    List<User> findByNameStartingWith(String name);
    List<User> findByNameEndingWith(String name);
    List<User> findByNameContaining(String name);

    List<User> findByNameLike(String name);
}
