package org.example.recipe.dto;

import lombok.Data;
import org.example.recipe.model.Ingredient;
@Data
public class IngredientQuantity {
    private Ingredient ingredient; // 
    private Double amount; // Количесто
}
