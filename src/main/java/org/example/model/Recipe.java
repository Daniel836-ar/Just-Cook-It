package org.example.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipes")  // название таблички
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "namerecipe")
    private String name;
    @Column(name = "instruction")
    private String instructions;

    //  Связь между рецептами и количеством ингридиентов
    @OneToMany(mappedBy = "recipe",cascade = CascadeType.ALL)

    private List<Amount> amounts = new ArrayList<>();

    public Recipe() {}


    public Recipe(String name, String instructions, List<Amount> amounts) {
        this.name = name;
        this.instructions = instructions;
        this.amounts = amounts;
    }


    // Геттеры , сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Amount> getAmounts() {
        return amounts;
    }

    public void setAmounts(List<Amount> amounts) {
        this.amounts = new ArrayList<>(); // всегда новый список

        if (amounts != null) {
            for (Amount amount : amounts) {
                // Прямая установка без вызова методов
                this.amounts.add(amount);
                amount.setRecipe(this);
            }
        }
    }




    @Override
    public String toString() {
        return "Название рецепта:" +
                name  +
                "\nИнтсрукция по приготовлению: " + instructions + "\n";
    }
}