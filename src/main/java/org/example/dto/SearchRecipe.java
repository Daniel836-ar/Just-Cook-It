package org.example.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.example.model.Ingredient;

import java.util.ArrayList;
import java.util.List;

@Data
public class SearchRecipe {
    private String searchIngredientString;
    @NotEmpty(message = "Пустой список ингредиентов")
    private List<Ingredient> ingredients= new ArrayList<>();
}
