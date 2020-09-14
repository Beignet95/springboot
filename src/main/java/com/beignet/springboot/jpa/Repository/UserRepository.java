package com.beignet.springboot.jpa.Repository;

import com.beignet.springboot.jpa.bean.User;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, ID>, JpaSpecificationExecutor<User> {
     User findById(long id);

     User saveAndFlush(User user);

     @Query("select u from User u where u.age=?1")
     List<User> findUserByAge(@Param("age")Integer age);

     @Query("select u from User u where u.UserName=:name")
     List<User> findUserByName(@Param("name")String name);
}
