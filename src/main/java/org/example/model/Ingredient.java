package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ingredients")  // Название таблицы
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String amount; // "200г", "1 шт", "по вкусу" и подобное

    // Конструкторы
    public Ingredient() {}  // Обязательный пустой конструктор

    public Ingredient(String name, String amount) {
        this.name = name;
        this.amount = amount;
    }

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAmount() { return amount; }
    public void setAmount(String amount) { this.amount = amount; }
}