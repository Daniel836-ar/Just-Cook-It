package org.example.controller;

import lombok.extern.slf4j.Slf4j;
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
    public String Home(){
        return "home";
    }
    @ModelAttribute("searchRecipe")
    public SearchRecipe searchRecipe(){
        return new SearchRecipe();
    }



    @PostMapping("/searchIngredient")
    public String searchIngredient(@ModelAttribute("searchRecipe") SearchRecipe searchRecipe, Model model){
        Ingredient found = ingredientService.findByName(searchRecipe.getSearchIngredientString());
        if(found != null){
            log.info("Нашёл ингредиент "+searchRecipe.getSearchIngredientString());
            searchRecipe.getIngredients().add(found);
            searchRecipe.setSearchIngredientString("");
        }else{
            log.info("Не нашёл ингредиент "+searchRecipe.getSearchIngredientString());
            model.addAttribute("error", "Ингредиент не найден!");
        }




        log.info("Сейчас ингредиентов: "+ searchRecipe.getIngredients().size());

        return "redirect:/";
    }

}
