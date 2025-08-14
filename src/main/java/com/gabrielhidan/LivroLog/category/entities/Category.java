package com.gabrielhidan.LivroLog.category.entities;
import com.gabrielhidan.LivroLog.books.entities.Books;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category" , nullable = false , unique = true)
    private String category;

    @Column(name = "description" , nullable = false)
    private String description;


    @OneToMany(
            mappedBy = "category",
            cascade = CascadeType.ALL, // Propaga operações: deletar uma categoria deleta seus livros)
            orphanRemoval = true
    )
    private List<Books> booksList;
}
