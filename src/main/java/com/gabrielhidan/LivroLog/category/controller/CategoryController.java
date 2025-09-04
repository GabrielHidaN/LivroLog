package com.gabrielhidan.LivroLog.category.controller;
import com.gabrielhidan.LivroLog.category.entities.Category;
import com.gabrielhidan.LivroLog.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/create")
    public Category createCategory(Long id , @RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @PostMapping("/{id}")
    public Category updateCategory (@PathVariable  Long id , @RequestBody Category category){
        return categoryService.updateCategory(id , category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory (@PathVariable Long id){
        categoryService.deleteCategory(id);
    }

    @GetMapping("/")
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public Category getCategoryById (@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }
}
