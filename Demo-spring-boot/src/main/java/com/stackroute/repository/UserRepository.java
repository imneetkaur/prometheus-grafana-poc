package com.stackroute.repository;

import com.stackroute.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    /*@Modifying*//*
    @Query("update User u set u.name=:name where u.id=:id")
    public User updateUser(@Param("name") String name,
                           @Param("id") Integer id);*/
}
