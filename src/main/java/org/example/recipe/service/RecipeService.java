package org.example.recipe.service;

import org.example.recipe.model.Recipe;
import org.example.recipe.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class RecipeService{

    private RecipeRepository recipeRepository;
    @Autowired
    RecipeService(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }


    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe saveRecipe(Recipe recipe) {
        if (recipe.getAmounts() != null) {
            recipe.getAmounts().forEach(amount -> amount.setRecipe(recipe));
        }
        return recipeRepository.save(recipe);
    }

    public List<Recipe> findByName(String name) {
        return recipeRepository.findByName(name);
    }

}
