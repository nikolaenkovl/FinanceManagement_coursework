/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.financemanage.controller;

import com.mycompany.financemanage.model.Category;
import com.mycompany.financemanage.model.Expense;
import com.mycompany.financemanage.model.ExpenseData;
import com.mycompany.financemanage.repository.ExpenseRepository;
import com.mycompany.financemanage.service.ExpenseService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author vfvla
 */
@Controller
public class DiagramController {
    
    @Autowired
    ExpenseRepository expenseRepository;
    
    @Autowired
    private ExpenseService expenseService;

    @RequestMapping("/diagram")
    public String diagram(Model model) {
        ExpenseData expenseData = new ExpenseData(expenseRepository, expenseService);
        System.out.println(expenseData.getCategoryExpenses());
        model.addAttribute("expenseData", expenseData);
        return "diagram";
    }

}
