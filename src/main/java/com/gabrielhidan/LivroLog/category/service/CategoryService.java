package com.gabrielhidan.LivroLog.category.service;
import com.gabrielhidan.LivroLog.category.entities.Category;
import com.gabrielhidan.LivroLog.category.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id){
        Optional<Category> getById = categoryRepository.findById(id);
        if (getById.isPresent()){
            return getById.orElse(null);
        }
        return null;
    }

    public void deleteCategory(Long id){
        Optional<Category> getById = categoryRepository.findById(id);
        if (getById.isPresent()){
            categoryRepository.deleteById(id);
        }
    }

    public Category updateCategory (Long id , Category category){
        Optional<Category> getById = categoryRepository.findById(id);
        if (getById.isPresent()){
            category.setId(id);
            return categoryRepository.save(category);
        }
        return null;
    }
}
