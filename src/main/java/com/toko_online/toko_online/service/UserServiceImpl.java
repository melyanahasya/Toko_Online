package com.toko_online.toko_online.service;

import com.toko_online.toko_online.exception.InternalErrorException;
import com.toko_online.toko_online.exception.NotFoundException;
import com.toko_online.toko_online.model.User;
import com.toko_online.toko_online.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public Object getAllUser() {
       try{
           return userRepository.findAll();
       } catch (Exception e) {
           return "Kesalahan memunculkan data";
       }
    }

    @Override
    public User addUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new InternalErrorException("Email sudah digunakan");
        }
        return userRepository.save(user);
    }
    @Override
    public Object getUser(Long Id) {
        var user = userRepository.findById(Id).orElseThrow(() -> new NotFoundException("Id tidak Ditemukkan"));
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new InternalErrorException("Kesalahan Memunculkan data");
        }
    }

    @Override
    public User editUser(Long id, String userName, String email, Integer age, String address, Integer phoneNumber) {
        User user =  userRepository.findById(id).get();
        user.setUserName(userName);
        user.setEmail(email);
        user.setAge(age);
        user.setAddress(address);
        user.setPhoneNumber(phoneNumber);
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long Id) {
        userRepository.deleteById(Id);
    }

}
