package com.gabrielhidan.LivroLog.category.controller;
import com.gabrielhidan.LivroLog.category.dto.CategoryDTO;
import com.gabrielhidan.LivroLog.category.service.CategoryService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<String> createCategory(Long id, @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO category = categoryService.createCategory(categoryDTO);
        return ResponseEntity.ok("Category Created Success!");
    }


    @GetMapping("/")
    public ResponseEntity<List<CategoryDTO>> getAllCategory() {
        List<CategoryDTO> category = categoryService.getAllCategory();
        return ResponseEntity.ok(category);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
        CategoryDTO category = categoryService.getCategoryById(id);
        if (category != null){
            return ResponseEntity.status(HttpStatus.FOUND)
                    .body(category);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Category not found!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        CategoryDTO category = categoryService.getCategoryById(id);
        if (category != null){
            categoryService.deleteCategory(id);
            return ResponseEntity.ok("Category Deleted Success!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Category not found!");

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody CategoryDTO category) {
        CategoryDTO updateCategory = categoryService.updateCategory(id , category);
        if(updateCategory != null){
            return ResponseEntity.ok(updateCategory);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Category not found!");
    }
}

