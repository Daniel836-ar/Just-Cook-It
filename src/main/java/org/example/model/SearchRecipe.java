package org.example.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class SearchRecipe {
    @NotEmpty(message = "Пустой список ингредиентов")
    List<Ingredient> ingredients;
}
