package org.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "amounts")  // Название таблицы
public class Amount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double amount; //количество 3 ,2,1


    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    // связь с одним ингридиентмами
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    public Amount() {
    }

    public Amount(double amount) {
        this.amount = amount;

    }
    public Amount(double amount, Ingredient ingredient) {
        this.amount = amount;
        this.ingredient = ingredient;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
