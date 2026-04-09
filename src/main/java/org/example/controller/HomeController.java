package org.example.controller;

import org.example.model.Recipe;
import org.example.model.SearchRecipe;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String Home(){
        return "home";
    }
    @ModelAttribute("searchRecipe")
    public SearchRecipe searchRecipe(){
        return new SearchRecipe();
    }


}
