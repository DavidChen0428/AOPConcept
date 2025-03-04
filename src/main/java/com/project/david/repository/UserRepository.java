package com.project.david.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.david.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
