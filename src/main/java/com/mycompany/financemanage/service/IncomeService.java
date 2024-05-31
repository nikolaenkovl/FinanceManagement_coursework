/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.financemanage.service;

import com.mycompany.financemanage.model.Expense;
import com.mycompany.financemanage.model.Income;
import com.mycompany.financemanage.repository.ExpenseRepository;
import com.mycompany.financemanage.repository.IncomeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vfvla
 */
@Service("incomeService")
@Transactional
public class IncomeService {
    
    @Autowired
    IncomeRepository incomeRepository;
    
        public List<Income> findAll(){
        return incomeRepository.findAll();
    }
    
    public Page<Income> findAll(Pageable page){
        return incomeRepository.findAll(page);
    }
    
        public void saveIncome(Income income) {
        incomeRepository.save(income);
    }

    public void deleteIncomeById(Long incomeId) {
        incomeRepository.deleteById(incomeId);
    }

}
