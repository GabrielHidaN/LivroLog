package com.gabrielhidan.LivroLog.category.dto;

import com.gabrielhidan.LivroLog.books.entities.Books;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private Long id;
    private String category;
    private String description;
    private List<Books> booksList;
}
