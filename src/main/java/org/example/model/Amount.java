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

    // связь с одним рецептом
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "amounts")
    private List<Ingredient> ingredients;

    public Amount() {
    }

    public Amount(int amount) {
        this.amount = amount;

    }
    public Amount(int amount, Ingredient ingredient) {
        this.amount = amount;
        this.ingredients = ingredients;
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
