package com.example.Repo;

import com.example.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IUserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.email= :email and u.password= :password")
    List<User> find(@Param("email") String email, @Param("password") String password);
}
