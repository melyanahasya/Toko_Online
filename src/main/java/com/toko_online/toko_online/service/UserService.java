package com.toko_online.toko_online.service;

import com.toko_online.toko_online.model.User;

public interface UserService {

    Object getAllUser();
    User addUser(User user);
    Object getUser(Long Id);
    User editUser(Long Id, String userName, String email, Integer age, String address, Integer phoneNumber);
    void deleteUserById(Long Id);
}
