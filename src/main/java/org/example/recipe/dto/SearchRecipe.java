package org.example.recipe.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SearchRecipe {
    private String searchIngredientString;
    @NotEmpty(message = "Пустой список ингредиентов")
    private List<IngredientQuantity> ingredientQuantities= new ArrayList<>();
}
