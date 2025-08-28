package com.gabrielhidan.LivroLog.category.repository;

import com.gabrielhidan.LivroLog.category.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category , Long> {
}
