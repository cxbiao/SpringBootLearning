package com.bryan.controller;

import com.bryan.domain.User;
import com.bryan.domain.UserCustom;
import com.bryan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController  {

    @Autowired
    private UserService userService;


    @PostMapping("/findUserList")
    public List<UserCustom> findUserList() throws Exception {
        List<UserCustom> listUsers = userService.findUserList(null);
        return listUsers;
    }

    @PostMapping("/editUser")
    public String editUser(UserCustom userCustom) {
        userService.updateUser(userCustom);
        return "success";
    }

    @PostMapping("/addUser")
    public User addUser(User user){
        userService.insertUser(user);
        return user;
    }


    @PostMapping("/deleteUser")
    public String deleteUser(int id){
        userService.deleteUser(id);
        return "success";
    }
}
