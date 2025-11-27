package org.example.service;

import org.example.model.Amount;
import org.example.model.Ingredient;
import org.example.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeSearchService {
    private RecipeService recipeService;
    private AmountService amountService;

    @Autowired
    RecipeSearchService(RecipeService recipeService, AmountService amountService){
        this.recipeService = recipeService;
        this.amountService = amountService;
    }

    @Transactional
    public List<Recipe> findByIngredients(List<Amount> availableAmounts) {
        List<Recipe> allRecipes = recipeService.getAllRecipes();
        List<Recipe> matchRecipe = new ArrayList<>();

        System.out.println("Доступные ингредиенты:");
        for (Amount available : availableAmounts) {
            System.out.println("  - " + available.getIngredient().getName() + ": " + available.getAmount() + " шт.");
        }

        System.out.println("Всего рецептов в базе: " + allRecipes.size());

        for (Recipe recipe : allRecipes) {
            if (canMakeRecipe(recipe, availableAmounts)) {
                matchRecipe.add(recipe);
                System.out.println("+ Подходит: " + recipe.getName());
            } else {
                System.out.println("- Не подходит: " + recipe.getName());
            }
        }

        return matchRecipe;
    }

    private boolean canMakeRecipe(Recipe recipe, List<Amount> availableAmounts) {
        // Проверяю каждый ингредиент в рецепте
        for (Amount recipeAmount : recipe.getAmounts()) {
            Ingredient neededIngredient = recipeAmount.getIngredient();
            int neededAmount = recipeAmount.getAmount();

            // Ищу этот же ингредиент в доступных
            boolean hasEnough = false;
            for (Amount availableAmount : availableAmounts) {
                if (isSameIngredient(availableAmount.getIngredient(), neededIngredient)) {
                    // Сверяю кол-во
                    if (availableAmount.getAmount() >= neededAmount) {
                        hasEnough = true;
                        break;
                    }
                }
            }

            // Если не хватает хотя бы 1 ингредиента - приготовить невозможно
            if (!hasEnough) {
                return false;
            }
        }

        return true;
    }

    // сравнение без регистров и пробелов
    private boolean isSameIngredient(Ingredient ing1, Ingredient ing2) {
        if (ing1 == null || ing2 == null) {
            return false;
        }

        String name1 = ing1.getName().toLowerCase().trim();
        String name2 = ing2.getName().toLowerCase().trim();

        return name1.equals(name2);
    }
}