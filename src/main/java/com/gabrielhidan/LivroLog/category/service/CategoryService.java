package com.gabrielhidan.LivroLog.category.service;
import com.gabrielhidan.LivroLog.category.dto.CategoryDTO;
import com.gabrielhidan.LivroLog.category.entities.Category;
import com.gabrielhidan.LivroLog.category.mapper.CategoryMapper;
import com.gabrielhidan.LivroLog.category.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Category category = categoryMapper.toEntity(categoryDTO);
        category = categoryRepository.save(category);

        return categoryMapper.toDTO(category);
    }

    public List<CategoryDTO> getAllCategory(){
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList.stream()
                .map(categoryMapper::toDTO)
                .collect(Collectors.toList());

    }

    public CategoryDTO getCategoryById(Long id){
        Optional<Category> getById = categoryRepository.findById(id);
        if (getById.isPresent()){
            return  getById.map(categoryMapper::toDTO).orElse(null);
        }
        return null;
    }

    public void deleteCategory(Long id){
        Optional<Category> getById = categoryRepository.findById(id);
        if (getById.isPresent()){
            categoryRepository.deleteById(id);
        }
    }

    public CategoryDTO updateCategory (Long id , CategoryDTO categoryDTO){
        Optional<Category> getById = categoryRepository.findById(id);
        if (getById.isPresent()){
            Category categoryUpdate = categoryMapper.toEntity(categoryDTO);
            categoryUpdate.setId(id);
            Category categorySave = categoryRepository.save(categoryUpdate);
            return categoryMapper.toDTO(categorySave);
        }
        return null;
    }
}
