package org.example.service;

import org.example.model.Ingredient;
import org.example.model.Recipe;
import org.example.repository.AmountRepository;
import org.example.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeSearchService {
    private RecipeService recipeService;
    private AmountService amountService;
    @Autowired
    RecipeSearchService(RecipeService recipeService, AmountService amountService){
        this.recipeService = recipeService;
        this.amountService = amountService;
    }
    public List<Recipe> findByIngredients(List<Ingredient> ingredients) {
        // ingridients содержит все ингридиенты, которые есть в холодосе, нужно
        // сделать логику как их доставать
        return recipeService.getAllRecipes();
    }
}
