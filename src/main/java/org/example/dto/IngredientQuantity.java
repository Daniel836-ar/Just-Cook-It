package org.example.dto;

import lombok.Data;
import org.example.model.Ingredient;
@Data
public class IngredientQuantity {
    private Ingredient ingredient; // 
    private Double amount; // Количесто
}
