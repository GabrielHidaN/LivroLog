package com.gabrielhidan.LivroLog.category.controller;
import com.gabrielhidan.LivroLog.category.dto.CategoryDTO;
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
    public CategoryDTO createCategory(Long id , @RequestBody CategoryDTO category){
        return categoryService.createCategory(category);
    }

    @PostMapping("/{id}")
    public CategoryDTO updateCategory (@PathVariable  Long id , @RequestBody CategoryDTO category){
        return categoryService.updateCategory(id , category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory (@PathVariable Long id){
        categoryService.deleteCategory(id);
    }

    @GetMapping("/")
    public List<CategoryDTO> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public CategoryDTO getCategoryById (@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }
}
