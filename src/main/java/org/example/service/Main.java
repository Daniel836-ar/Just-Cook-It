package org.example.service;

import org.example.model.Amount;
import org.example.model.Ingredient;
import org.example.model.Recipe;
import org.example.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {

    private final RecipeService recipeService;

    @Autowired
    public Main(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    //наш новый main
    @Override
    public void run(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ingredient ingredient = new Ingredient("Яйцо");
        Ingredient ingredient2 = new Ingredient("яблоко");


        // Тестовые листы ингридиентов
        List<Amount> amounts1 = new ArrayList<>(Arrays.asList(new Amount(3,ingredient)));
        List<Amount> amounts2 = new ArrayList<>(Arrays.asList(new Amount(1,ingredient2)));



        Recipe recipe1 = new Recipe("Яишница", "Яйца на сковороду разбиаешь и всё", amounts1);
        Recipe recipe2 = new Recipe("фрукты с яйцом", "Следуй инструкции на пачке", amounts2);

        // Сохраняем через jpa
        recipeService.saveRecipe(recipe1);
        recipeService.saveRecipe(recipe2);

        System.out.println("Тестовые данные сохранены");



        //Здесь ты спрашиваешь у пользователя количество продуктов ------------------------------------

        // поиск (Здесь по названию , ты должен сделать по количеству продуктов)
        System.out.print("Введите название рецепта для поиска: ");
        String nameFind = scanner.nextLine();


        List<Recipe> recipeFind = recipeService.findByName(nameFind);

        if(recipeFind.isEmpty()) {
            System.out.println("Не нашли такого рецепта");
        } else {
            // просто вывожу всё
            recipeFind.forEach(System.out::println);
        }
        scanner.close();

        // закончил спрашивать и уже выдал рецепт или сказал , что такого рецепта нет -------------------




//        // все рецепты для проверки
//        System.out.println("\n Все рецепты в базе: ");
//        recipeService.getAllRecipes().stream().forEach(System.out::println);


        // Завершаем работу
        System.exit(0);
    }
}