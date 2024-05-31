/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.financemanage.controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.mycompany.financemanage.model.Category;
import com.mycompany.financemanage.model.Expense;
import com.mycompany.financemanage.model.User;
import com.mycompany.financemanage.repository.ExpenseRepository;
import com.mycompany.financemanage.repository.IncomeRepository;
import com.mycompany.financemanage.repository.UserRepository;
import com.mycompany.financemanage.service.CategoryService;
import com.mycompany.financemanage.service.ExpenseService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author vfvla
 */
@Controller
@RequestMapping("/user_expenses")
public class ExpenseController {
    
    @Autowired
    ExpenseService expenseService;
    
    @Autowired
    CategoryService categoryService;
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    IncomeRepository incomeRepository;
    
    @Autowired
    ExpenseRepository expenseRepository;
    
    @RequestMapping("/findall")
    public String findAll(Model model) {
        List<Expense> expenses = expenseService.findAll();
        model.addAttribute("expenses", expenses);

        int totalIncome = incomeRepository.getTotalIncome();
        
        int totalExpense = expenseRepository.getTotalExpense();
        
        int balance = totalIncome - totalExpense;
        
        model.addAttribute("balance", balance);
        
        Set<Integer> categoryIds = expenses.stream().map(Expense::getUser_category_id).collect(Collectors.toSet());
        List<Category> categories = categoryService.findAllCategories();
        model.addAttribute("categories", categories);

        return "all_expenses";
    }
    

    
    @GetMapping("/delete_expense")
    public String deleteExpense(@RequestParam("expense_id") Long expenseId) {//поменять
        expenseService.deleteExpenseById(expenseId);
        return "redirect:/user_expenses/findall";
    }
  
    @PostMapping("/add_expense")
    public String addExpense(@RequestParam("expense_value") int expenseValue,
                             @RequestParam("expenseCategoryId") int categoryId,
                             @RequestParam("expense_date") String expenseDate) {
        Expense expense = new Expense();
        expense.setExpenseValue(expenseValue);
        expense.setUser_category_id(categoryId);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = formatter.parse(expenseDate);
            expense.setExpense_date(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        expenseService.saveExpense(expense);
        return "redirect:/user_expenses/findall";
    }
    @GetMapping("/balance")
    @ResponseBody
    public int getBalance() {
        int totalIncome = incomeRepository.getTotalIncome();
        int totalExpense = expenseRepository.getTotalExpense();
        int balance = totalIncome - totalExpense;
        return balance;
    }
    
}

