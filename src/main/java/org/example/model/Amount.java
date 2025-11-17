package org.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "amounts")  // Название таблицы
public class Amount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int amount; //количество 3 ,2,1


    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    // связь с одним ингридиентмами
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    public Amount() {
    }

    public Amount(int amount) {
        this.amount = amount;

    }
    public Amount(int amount, Ingredient ingredient) {
        this.amount = amount;
        this.ingredient = ingredient;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
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
