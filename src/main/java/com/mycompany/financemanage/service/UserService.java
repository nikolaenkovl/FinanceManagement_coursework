/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.financemanage.service;

import com.mycompany.financemanage.model.User;
import com.mycompany.financemanage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vfvla
 */
@Service("userService")
@Transactional
public class UserService {
    
    @Autowired
    UserRepository userRepository;
    
    public User findUserById(long userId) {
        return userRepository.findById(userId);
    }
    
    
}
