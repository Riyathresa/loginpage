package com.example.loginpage.demologinpage.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.loginpage.demologinpage.Model.Login;


public interface LoginRepository extends JpaRepository<Login, Long> {
    Login findByUserid(String userid);
    
}
