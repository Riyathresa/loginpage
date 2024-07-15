package com.example.loginpage.demologinpage.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loginpage.demologinpage.Model.Login;
import com.example.loginpage.demologinpage.Repository.LoginRepository;

@Service
public class LoginService {
 @Autowired
    private LoginRepository loginRepository;

    public boolean validateUser(String userid, String password) {
        Login login = loginRepository.findByUserid(userid);
        return login != null && login.getPassword().equals(password);
    }
}
