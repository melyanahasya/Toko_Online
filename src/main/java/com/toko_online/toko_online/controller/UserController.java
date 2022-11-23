package com.toko_online.toko_online.controller;

import com.toko_online.toko_online.model.User;
import com.toko_online.toko_online.response.CommonResponse;
import com.toko_online.toko_online.response.ResponeHelper;
import com.toko_online.toko_online.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
public class      UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public Object getAllUser(){
        return ResponeHelper.ok(userService.getAllUser()) ;
    }


    @GetMapping("/{Id}")
    public Object getUser(@PathVariable("Id") Long Id) {
        return ResponeHelper.ok(userService.getUser(Id));
    }

    @PostMapping
    public ResponseEntity<CommonResponse<User>> addUser(@RequestBody User user) {
        return ResponeHelper.ok(userService.addUser(user));
    }

    @PutMapping("/{Id}")
    public ResponseEntity<CommonResponse<User>> editUserById(@PathVariable("Id") Long Id, @RequestBody User user) {
        return ResponeHelper.ok(userService.editUser(Id, user.getUserName(), user.getEmail(), user.getAge(), user.getAddress(), user.getPhoneNumber()));
    }

    @DeleteMapping("/{Id}")
    public void deleteUserById(@PathVariable("Id") Long Id) { userService.deleteUserById(Id);}
}
