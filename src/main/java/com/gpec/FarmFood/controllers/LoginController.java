package com.gpec.FarmFood.controllers;

import com.gpec.FarmFood.servises.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    UserDetails user;

    @GetMapping(value = "/login/{userEmeil}/{password}")
    public String userLogin(String userEmail, String password) {
        if (userEmail == null || password == null) {
            throw new IllegalArgumentException(" App exception: User Email or password not entered! ");
        }
        try {
            UserDetails user = userService.loadUserByUsername(userEmail, password);
        } catch (UsernameNotFoundException e) {
            throw new IllegalArgumentException(" App exception: wrong login or password!" + e);
        }
        if (user == null) {
            return "Faild login : " + userEmail;
        }
        return "Access login : " + userEmail;
    }

    @PostMapping(value = "/registration/{userEmail}/{password}")
    public String userRegistration(String userEmail, String password) {
        if (userEmail.length() < 3 || userEmail.length() > 30) {
            throw new IllegalArgumentException("Invalid email length");
        }
        if (password.length() < 3 || password.length() > 30) {
            throw new IllegalArgumentException("Invalid password length");
        }
        return null; //userService.saveNewUser(userEmail, password);
    }

    @PostMapping(value = "/delete/{userEmail}/{password}")
    public String userDelete(String userEmail, String password) {
        return null; //userService.deleteUser(userEmail, password);
    }
}


//    @GetMapping(value = "/login")
//    public UserDetails adminLogin() throws SQLException {
////        Connection connect = DriverManager.getConnection("jdbc:postgresql://localhost/postgres?" +
////                "user=" + "postgres" + "&password=" + "password");
////        Connection connect = DriverManager.getConnection(
////                "jdbc:postgresql://ec2-52-213-119-221.eu-west-1.compute.amazonaws.com:5432/d8i6sb8l5ki7vb?" +
////                        "sslmode=require");// + "user=" + "hnjcutqdbpohlm" + "&password=" + "a812af31aa76b9a960ce413a072e39e1fdb5361ccf8d45c851948fa8967ac4e2");
//      //  System.out.println(connect.getSchema());
//        return userService.loadUserByUsername("admin");
//    }
