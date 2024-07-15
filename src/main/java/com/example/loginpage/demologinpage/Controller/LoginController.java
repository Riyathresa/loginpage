package com.example.loginpage.demologinpage.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.loginpage.demologinpage.Service.LoginService;

@Controller
@SessionAttributes("userid")
public class LoginController {

    @Autowired
    LoginService service;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(ModelMap map) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String welcomePage(ModelMap model, @RequestParam String userid, @RequestParam String password) {
        boolean isValidUser = service.validateUser(userid, password);
        if (!isValidUser) {
            model.put("errorMessage", "Access Denied, Invalid Credentials");
            return "login";
        }
        model.put("userid", userid);
        model.put("password", password);
        return "welcom";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(ModelMap model) {
        model.clear();
        return "login";
    }
}
