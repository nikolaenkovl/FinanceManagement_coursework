/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.financemanage.model;

import com.mycompany.financemanage.repository.ExpenseRepository;
import com.mycompany.financemanage.service.ExpenseService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author vfvla
 */
@Component
public class ExpenseData {
    private Map<String, Integer> categoryExpenses;
    private ExpenseService expenseService;
    private ExpenseRepository expenseRepository;

    public ExpenseData(ExpenseRepository expenseRepository, ExpenseService expenseService) {
        this.expenseRepository = expenseRepository;
        this.expenseService = expenseService;
        categoryExpenses = new HashMap<>();
        List<Object[]> results = expenseRepository.getTotalExpenseByCategory();

        for (Object[] result : results) {
            Long categoryId = ((Number) result[0]).longValue();
            Long totalExpense = (Long) result[1];

            String categoryName = expenseService.getCategoryNameById(categoryId);

            categoryExpenses.put(categoryName, totalExpense.intValue());
        }
    }
    public Map<String, Integer> getCategoryExpenses() {
        return categoryExpenses;
    }
    public void setCategoryExpenses(Map<String, Integer> categoryExpenses) {
        this.categoryExpenses = categoryExpenses;
    }
    
}

