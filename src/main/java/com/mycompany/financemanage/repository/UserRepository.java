/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.financemanage.repository;

import com.mycompany.financemanage.model.Category;
import com.mycompany.financemanage.model.Expense;
import com.mycompany.financemanage.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author vfvla
 */
public interface UserRepository extends JpaRepository<User, Long> {

    public User findById(long userId);
    public User findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    
}
