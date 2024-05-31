/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.financemanage.repository;

import com.mycompany.financemanage.model.Expense;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author vfvla
 */
public interface ExpenseRepository extends JpaRepository<Expense, Long>{

    @Query("SELECT e.user_category_id, SUM(e.expense_value) FROM Expense e GROUP BY e.user_category_id")
    List<Object[]> getTotalExpenseByCategory();
    
    @Query("SELECT SUM(e.expense_value) FROM Expense e")
    int getTotalExpense();
}