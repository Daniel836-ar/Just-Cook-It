package org.example.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ingredients")  // Название таблицы
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nameingridient")
    private String name;
    @Column(name = "Measured")
    private String measured;

    


    // Конструкторы
    public Ingredient() {}  // Обязательный пустой конструктор

    public Ingredient(String name, String measured) {
        this.name = name;
        this.measured = measured;
    }

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMeasured() {
        return measured;
    }

    public void setMeasured(String measured) {
        this.measured = measured;
    }
}