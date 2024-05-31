/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.financemanage.model;

import com.mycompany.financemanage.repository.CategoryRepository;
import com.mycompany.financemanage.repository.ExpenseRepository;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author vfvla
 */
@Entity
@Table(name="expense")
public class Expense {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name="expense_value")
    private int expense_value;
    
    @Column(name="expense_date")
    private Date expense_date;

    @Column(name="user_category_id")
    private int user_category_id;
    

    public Expense(){
        
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getExpense_value() {
        return expense_value;
    }

    public void setExpense_value(int expense_value) {
        this.expense_value = expense_value;
    }

    public Date getExpense_date() {
        return expense_date;
    }

    public void setExpense_date(Date expense_date) {
        this.expense_date = expense_date;
    }

    public int getUser_category_id() {
        return user_category_id;
    }

    public void setUser_category_id(int user_category_id) {
        this.user_category_id = user_category_id;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expense_date=expenseDate;
    }

    public void setExpenseValue(int expenseValue) {
        this.expense_value=expenseValue;
    }

    public void setUserCategoryId(int expenseCategoryId) {
        this.user_category_id=expenseCategoryId;
    }
  
}
