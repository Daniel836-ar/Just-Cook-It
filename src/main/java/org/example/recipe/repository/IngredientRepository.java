package org.example.recipe.repository;

import org.example.recipe.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Long> {
    List<Ingredient> findByName(String name);
}
