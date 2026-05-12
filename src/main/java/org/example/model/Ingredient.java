package org.example.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
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

}