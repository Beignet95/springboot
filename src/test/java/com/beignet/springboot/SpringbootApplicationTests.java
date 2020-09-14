package com.beignet.springboot;

import com.beignet.springboot.jpa.Repository.UserRepository;
import com.beignet.springboot.jpa.bean.User;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SpringbootApplicationTests {
    @Autowired
    UserRepository userRepository;

    @Test
    void contextLoads() {
        User user = new User();
        user.setId(2);
        user.setAge(32);
        user.setUserName("刘亦菲");
        user.setSex("女");
        User res = userRepository.saveAndFlush(user);
        System.out.println(res);
    }

    @Test
    void saveUser() {
        User user = new User();
        user.setAge(25);
        user.setUserName("Beignet");
        user.setSex("男");
        User res = userRepository.saveAndFlush(user);
        System.out.println(res);
    }

    @Test
    void findUserById() {
        User user = userRepository.findById(2);
        System.out.println(user);
    }

    @Test
    void findAll() {
        List<User> userList = userRepository.findAll();
        for(User user:userList){
            System.out.println(user);
        }

    }

    @Test
    void findPage() {
        Sort sort = Sort.by(Sort.Direction.ASC,"age");
        Pageable pageable = PageRequest.of(1,2,sort);
        Page<User>  page = userRepository.findAll(pageable);
        for(User user:page){
            System.out.println(user);
        }
    }

    @Test
    void findPageByMoreSort() {
        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.ASC,"sex"));
        orders.add(new Sort.Order(Sort.Direction.ASC,"age"));
        Pageable pageable = PageRequest.of(0,10,Sort.Direction.ASC,"age");
        Page<User>  page = userRepository.findAll(pageable);
        System.out.println("人数："+page.getTotalElements());
        List<User> users = page.getContent();
        for(User user: page.getContent()){
            System.out.println(user);
        }
    }

    @Test
    void findUserListByAge() {
        List<User> users = userRepository.findUserByAge(35);
        for(User user: users){
            System.out.println(user);
        }
    }

    @Test
    void findUserListByName() {
        List<User> users = userRepository.findUserByName("胡歌");
        for(User user: users){
            System.out.println(user);
        }
    }

    @Test
    void findUserBySpecification() {
        String sex = "女";
        Integer age = 30;
        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> preList = new ArrayList();
                if(StringUtils.isNotBlank(sex)){
                    Predicate predicate = criteriaBuilder.like(root.get("sex"),sex);
                    preList.add(predicate);
                }
                if(age!=null){
                    Predicate predicate = criteriaBuilder.gt(root.get("age"),age);
                    preList.add(predicate);
                }
                Predicate[] predicates = new Predicate[preList.size()];
                return criteriaBuilder.and(preList.toArray(predicates));
            }
        };
        List<User> users = userRepository.findAll(specification);
        for(User user: users){
            System.out.println(user);
        }
    }

}
