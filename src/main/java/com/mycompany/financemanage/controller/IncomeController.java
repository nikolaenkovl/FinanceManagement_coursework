/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.financemanage.controller;

import com.mycompany.financemanage.model.Expense;
import com.mycompany.financemanage.model.Income;

import com.mycompany.financemanage.service.ExpenseService;
import com.mycompany.financemanage.service.IncomeService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author vfvla
 */
@Controller
@RequestMapping("/user_incomes")
public class IncomeController {
    
    @Autowired
    IncomeService incomeService;
    
    /*@RequestMapping("/findall")
    public String findAll(Model model){
        //Sort sort = Sort.by(Sort.Order.asc("year"));
        List<Income> incomes = incomeService.findAll();
        model.addAttribute("incomes", incomes);
        return "all_incomes";
    }*/

    @RequestMapping("/findallpages")
    public String findAllPages(Model model, Pageable page, Sort sort){
        Sort.Order order = null;
        if(sort!=null && sort.iterator().hasNext()){
            order= sort.iterator().next();
        }
        model.addAttribute("sort",(order!=null)?order.getProperty():"");
        model.addAttribute("dir",(order!=null)?order.getDirection():"");
        model.addAttribute("page", incomeService.findAll(page));
        return "income_pages";
    }
    
    
    @GetMapping("/delete_income")
    public String deleteIncome(@RequestParam("income_id") Long incomeId) {
        incomeService.deleteIncomeById(incomeId);
        return "redirect:/user_incomes/findallpages";
    }

    @PostMapping("/add_income")
    public String addIncome(@RequestParam("income_amount") int incomeValue,
                             @RequestParam("income_date") String incomeDate) {
        Income income = new Income();
        income.setIncome_amount(incomeValue);

        // Преобразуйте строку expenseDate в объект типа Date
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = formatter.parse(incomeDate);
            income.setIncome_date(date);
        } catch (ParseException e) {
            // Обработка ошибки, если произошла ошибка при преобразовании даты
            e.printStackTrace();
        }

        incomeService.saveIncome(income);
        return "redirect:/user_incomes/findallpages";
    }
    
}
