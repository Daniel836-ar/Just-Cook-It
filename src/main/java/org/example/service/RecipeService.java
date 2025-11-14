package org.example.service;

import jakarta.transaction.Transactional;
import org.example.model.Ingredient;
import org.example.model.Recipe;
import org.example.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class RecipeService{

    RecipeRepository recipeRepository;
    @Autowired
    RecipeService(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }


    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public List<Recipe> findByName(String name) {
        return recipeRepository.findByName(name);
    }

    public List<Recipe> findByIngredients(List<Ingredient> ingredients) {
        // поделать тут что то !




        // ingridients содержит все ингридиенты, которые есть в холодосе, нужно
        // сделать логику как их доставать
        return recipeRepository.findAll();
    }
}
