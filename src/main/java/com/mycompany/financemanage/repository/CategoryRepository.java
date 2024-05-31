/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.financemanage.repository;

import com.mycompany.financemanage.model.Category;
import com.mycompany.financemanage.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author vfvla
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

}

//public interface CategoryRepository extends JpaRepository<Category, Long> {
//
//    public Category findById(long categoryId);
//    
//}
