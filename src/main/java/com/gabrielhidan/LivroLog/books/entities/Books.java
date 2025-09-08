package com.gabrielhidan.LivroLog.books.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gabrielhidan.LivroLog.category.entities.Category;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = {"category"})
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title" , nullable = false , unique = true)
    private String title;

    @Column(name = "author" , nullable = false)
    private String author;

    @Column(name = "language" , nullable = false)
    private String language;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id" , nullable = false)
    private Category category;

}
