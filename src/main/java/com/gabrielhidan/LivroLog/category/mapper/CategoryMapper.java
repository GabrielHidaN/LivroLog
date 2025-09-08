package com.gabrielhidan.LivroLog.category.mapper;
import com.gabrielhidan.LivroLog.category.dto.CategoryDTO;
import com.gabrielhidan.LivroLog.category.entities.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public Category toEntity(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setCategory(categoryDTO.getCategory());
        category.setDescription(categoryDTO.getDescription());
        category.setBooksList(categoryDTO.getBooksList());

        return category;
    }

    public CategoryDTO toDTO(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setCategory(category.getCategory());
        categoryDTO.setDescription(category.getDescription());
        categoryDTO.setBooksList(category.getBooksList());
        return categoryDTO;
    }
}
