/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.financemanage.repository;

import com.mycompany.financemanage.model.Expense;
import com.mycompany.financemanage.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author vfvla
 */
public interface IncomeRepository extends JpaRepository<Income, Long>{
    
    @Query("SELECT SUM(i.income_amount) FROM Income i")
    int getTotalIncome();
    
}
