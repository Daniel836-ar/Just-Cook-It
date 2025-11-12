package org.example.service;

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

        // Тестовые листы ингридиентов
        List<Ingredient> list1 = new ArrayList<>(Arrays.asList(
                new Ingredient("яйцо", "3 штуки"),
                new Ingredient("масло", "капля")
        ));
        List<Ingredient> list2 = new ArrayList<>(Arrays.asList(
                new Ingredient("пачка пельменей", "вода"),
                new Ingredient("масло", "капля")
        ));

        Recipe recipe1 = new Recipe("Яишница", "Яйца на сковороду разбиаешь и всё", list1);
        Recipe recipe2 = new Recipe("Пельмени", "Следуй инструкции на пачке", list2);

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