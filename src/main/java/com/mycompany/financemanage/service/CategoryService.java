/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.financemanage.service;

import com.mycompany.financemanage.model.Category;
import com.mycompany.financemanage.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vfvla
 */
@Service("categoryService")
@Transactional
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    
    public Optional<Category> findCategoryById(long categoryId) {
        return categoryRepository.findById(categoryId);
    }

    public List<Category> findCategoriesByIds(Set<Long> categoryIds) {
        return categoryRepository.findAllById(categoryIds);
    }

    public List<Category> findAllCategories() {
    return categoryRepository.findAll();
}
    
    
}
