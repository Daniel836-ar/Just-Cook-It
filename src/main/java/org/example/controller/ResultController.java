package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.SearchRecipe;
import org.example.model.Recipe;
import org.example.service.RecipeSearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@RequestMapping("/result")
@SessionAttributes("searchRecipe")
@Slf4j
public class ResultController {
    private final RecipeSearchService recipeSearchService;

    public ResultController(RecipeSearchService recipeSearchService) {
        this.recipeSearchService = recipeSearchService;
    }

    @GetMapping
    public String result(@ModelAttribute("searchRecipe") SearchRecipe searchRecipe, Model model){
        //List<Recipe> foundRecipes = recipeSearchService.findByIngredients(searchRecipe.getIngredientQuantities());
        return "result";
    }


}
