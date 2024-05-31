/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.financemanage.service;

import com.mycompany.financemanage.model.Category;
import com.mycompany.financemanage.model.Expense;
import com.mycompany.financemanage.repository.CategoryRepository;
import com.mycompany.financemanage.repository.ExpenseRepository;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vfvla
 */
@Service("expenseService")
@Transactional
public class ExpenseService {
    
    @Autowired
    ExpenseRepository expenseRepository;
    
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> findCategoriesByIds(Set<Long> categoryIds) {
        return categoryRepository.findAllById(categoryIds);
    }
    
    public String getCategoryNameById(Long categoryId) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);

        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            return category.getName();
        } else {
            return null;
        }
    }
    
    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }
    
    public void deleteExpenseById(Long id) {
        expenseRepository.deleteById(id);
    }

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    public void saveExpense(Expense expense) {
        expenseRepository.save(expense);
    }
    
}