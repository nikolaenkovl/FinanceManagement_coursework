/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.financemanage.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author vfvla
 */
@Entity
@Table(name="income")
public class Income {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name="income_amount")
    private int income_amount;
    @Column(name="income_date")
    private Date income_date = new Date();
    //SimpleDateFormat formatForIncomeDate = new SimpleDateFormat("E yyyy.MM.dd 'и время' hh:mm:ss a zzz");

    public Income(){
        
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIncome_amount() {
        return income_amount;
    }

    public void setIncome_amount(int income_amount) {
        this.income_amount = income_amount;
    }

    public Date getIncome_date() {
        return income_date;
    }

    public void setIncome_date(Date income_date) {
        this.income_date = income_date;
    }
    
    
}
