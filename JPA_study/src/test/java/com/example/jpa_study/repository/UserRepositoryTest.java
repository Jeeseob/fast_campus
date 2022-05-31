package com.example.jpa_study.repository;

import com.example.jpa_study.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/05/13
 */

@SpringBootTest // Spring Context를 Load하여 Test하겠다는 의미
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void select() {
//        System.out.println(userRepository.findByName("martin"));
//
//        System.out.println("findByEmail : " + userRepository.findByEmail("martin@fastcampus.com"));
//        System.out.println("getByEmail : " + userRepository.getByEmail("martin@fastcampus.com"));
//        System.out.println("readByEmail : " + userRepository.readByEmail("martin@fastcampus.com"));
//        System.out.println("queryByEmail : " + userRepository.queryByEmail("martin@fastcampus.com"));
//        System.out.println("searchByEmail : " + userRepository.searchByEmail("martin@fastcampus.com"));
//        System.out.println("streamByEmail : " + userRepository.streamByEmail("martin@fastcampus.com"));
//        System.out.println("findUserByEmail : " + userRepository.findUserByEmail("martin@fastcampus.com"));
//
//        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("martin"));
//        System.out.println("findFirst1ByName : " + userRepository.findFirst1ByName("martin"));

        System.out.println("findByEmailAndName : " + userRepository.findByEmailAndName("martin@fastcampus.com", "martin"));
        System.out.println("findByEmailOrName : " + userRepository.findByEmailOrName("martin@fastcampus.com", "martin"));

        System.out.println("findByCreateAtAfter : " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByIdAfter : " + userRepository.findByIdAfter(3L));

    }


    @Test
    @Transactional
    void update() {
        userRepository.save(new User("david", "david@fascampus.com"));

        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("martin-update@fastcampus.com");

        userRepository.save(user);
    }


    @Test
    @Transactional
    void exampleMatcher() {

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("name")
                .withMatcher("email", endsWith()); // contains : 포함 / endsWith : 끝이 일ㅡㄷㅅ

        Example<User> example = Example.of(new User("ma", "fastcampus.com"), matcher);

        // user 중 fastcampus.com으로 이메일이 끝나는 경우만 출력
        userRepository.findAll(example).forEach(System.out::println);
    }

    @Test
    @Transactional // 세션 유지
    void paging() {

        Page<User> users = userRepository.findAll(PageRequest.of(0, 3)); // page와 size는 미리 지정 --> page는 0부터 시작

        System.out.println("page : " + users);
        System.out.println("totalElements : " + users.getTotalElements()); // 전체 elements의 갯수 -> 테이블 전체 수
        System.out.println("totalPages : " + users.getTotalPages()); // 페이지가 몇 페이지까지 있는지
        System.out.println("numberOfElements : " + users.getNumberOfElements()); // 현재 가져온 record의 수
        System.out.println("sort : " + users.getSort()); // 정렬
        System.out.println("size : " + users.getSize()); // paging시 나누는 크기

        users.getContent().forEach(System.out::println); // 해당 object
    }

    @Test
    @Transactional
    void delete() {
        // DeleteAll은 여러번 쿼리가 날라간다.
        userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L,3L)));
        // 삭제연산을 할때, 따로 찾지 않고, 바로 한번에 삭제
        userRepository.deleteAllInBatch();

//        userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));

        userRepository.findAll().forEach(System.out::println);
    }

    @Test
    @Transactional
    void count() {

        // 해당 테이블에 몇개의 데이터가 존재하는지
        long count = userRepository.count();
        System.out.println(count);

        // 해당 id를 가지는 값이 존재하는지
        boolean exsist = userRepository.existsById(1L);
        System.out.println(exsist);


    }

    @Test
    @Transactional
    void create() {
//        // 저장하고, DB로 보내기
//        userRepository.save(new User("new martin", "martin@gmail.com"));
//        userRepository.flush();

        // saveAndFlush = save + flush 기능
        userRepository.saveAndFlush(new User("new martin", "martin@gmail.com"));
        userRepository.findAll().forEach(System.out::println);
    }

    @Test
    @Transactional
    void read() {

        User user = userRepository.getOne(1L);
        System.out.println(user);

        User user3 = userRepository.findById(1L).orElse(null);
        System.out.println(user3);

        User user1 = new User("jack", "jack@gmail.com");
        User user2 = new User("steve", "seteve@gamil.com");

        userRepository.saveAll(Lists.newArrayList(user1, user2));
        List<User> users = userRepository.findAll();
    }
}