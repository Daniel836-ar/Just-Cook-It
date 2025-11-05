package org.example;


import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String instructions;


    //добавление поля ингридиенты в бд
    private List<String> ingredients = new ArrayList<>(); // инициализируем, чтобы не было NPE

    public Recipe(){
    }

    public Recipe(String name,String instructions) {
        this.name = name;
        this.instructions = instructions;

    }

    public Recipe(String name, String instructions, List<String> ingredients) {
        this.name = name;
        this.instructions = instructions;
        this.ingredients = ingredients;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }


    @Override
    public String toString() {
        return "имя: "+name+", инструкция по приготовлению: "+instructions;
    }

}
