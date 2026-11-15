package org.example.recipe.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.recipe.dto.IngredientQuantity;
import org.example.recipe.model.Ingredient;
import org.example.recipe.dto.SearchRecipe;
import org.example.recipe.service.IngredientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

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
    public String home(Principal principal, Model model) {
        if (principal != null) {
            model.addAttribute("currentUserEmail", principal.getName());
        }
        return "home";
    }
    @ModelAttribute("searchRecipe")
    public SearchRecipe searchRecipe(Model model) {
        if (model.containsAttribute("searchRecipe")) {
            return (SearchRecipe) model.getAttribute("searchRecipe");
        }
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
    @PostMapping("/findRecipes")
    public String searchRecipes(){
        return "redirect:/result";
    }


}
