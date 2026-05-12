package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.IngredientQuantity;
import org.example.model.Ingredient;
import org.example.dto.SearchRecipe;
import org.example.service.IngredientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/")
@SessionAttributes("searchRecipe")
public class HomeController {
    IngredientService ingredientService;

    public HomeController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public String home(){
        return "home";
    }
    @ModelAttribute("searchRecipe")
    public SearchRecipe searchRecipe(){
        return new SearchRecipe();
    }



    @PostMapping("/searchIngredient")
    public String searchIngredient(@ModelAttribute("searchRecipe") SearchRecipe searchRecipe, Model model) {
        Ingredient found = ingredientService.findByName(searchRecipe.getSearchIngredientString());
        if (found != null) {
            IngredientQuantity ingredientQuantity = new IngredientQuantity();
            ingredientQuantity.setIngredient(found);
            ingredientQuantity.setAmount(0.0); // Начальное значение
            searchRecipe.getIngredientQuantities().add(ingredientQuantity);
        }

        return "redirect:/";
    }

    public String searchRecipes(){
        return "result";
    }


}
