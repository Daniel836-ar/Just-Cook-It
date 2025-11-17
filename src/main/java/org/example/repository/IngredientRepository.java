package org.example.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Long> {
    List<Ingredient> findByName(String name);
    List<Ingredient> findAll();
}
