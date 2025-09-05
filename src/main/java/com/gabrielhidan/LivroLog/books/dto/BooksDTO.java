package com.gabrielhidan.LivroLog.books.dto;

import com.gabrielhidan.LivroLog.category.entities.Category;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BooksDTO {

    private Long id;
    private String title;
    private String author;
    private String language;
    private String description;
    private Category category;
}
