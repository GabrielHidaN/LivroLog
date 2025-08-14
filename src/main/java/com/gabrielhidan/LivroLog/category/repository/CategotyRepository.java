package com.gabrielhidan.LivroLog.category.repository;

import com.gabrielhidan.LivroLog.category.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategotyRepository extends JpaRepository<Category , Long> {
}
