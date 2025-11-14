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



        // Тестовые листы ингридиентов
        List<Ingredient> list1 = new ArrayList<>(Arrays.asList(
                new Ingredient("яйцо", "2 штуки"),
                new Ingredient("масло сливочное", "1 ст.л."),
                new Ingredient("соль", "щепотка")
        ));
        List<Ingredient> list2 = new ArrayList<>(Arrays.asList(
                new Ingredient("яйцо", "3 штуки"),
                new Ingredient("молоко", "50 мл"),
                new Ingredient("соль", "по вкусу")
        ));
        List<Ingredient> list3 = new ArrayList<>(Arrays.asList(
                new Ingredient("яйцо", "1 штука"),
                new Ingredient("хлеб", "1 ломтик"),
                new Ingredient("масло растительное", "1 ч.л.")
        ));
        List<Ingredient> list4 = new ArrayList<>(Arrays.asList(
                new Ingredient("яйцо", "4 штуки"),
                new Ingredient("помидор", "1 штука"),
                new Ingredient("лук", "0.5 головки"),
                new Ingredient("соль", "щепотка")
        ));
        List<Ingredient> list5 = new ArrayList<>(Arrays.asList(
                new Ingredient("яйцо", "6 штук"),
                new Ingredient("сыр", "50 г"),
                new Ingredient("ветчина", "50 г"),
                new Ingredient("молоко", "100 мл")
        ));
        List<Ingredient> list6 = new ArrayList<>(Arrays.asList(
                new Ingredient("яйцо", "2 штуки"),
                new Ingredient("мука", "2 ст.л."),
                new Ingredient("сахар", "1 ст.л."),
                new Ingredient("молоко", "100 мл")
        ));

        List<Ingredient> list7 = new ArrayList<>(Arrays.asList(
                new Ingredient("пачка пельменей", "вода"),
                new Ingredient("масло", "капля")
        ));


        Recipe recipe1 = new Recipe("Яичница глазунья", "Разбить яйца на сковороду, посолить, жарить 3-4 минуты", list1);
        Recipe recipe2 = new Recipe("Классический омлет", "Взбить яйца с молоком, вылить на сковороду, жарить под крышкой", list2);
        Recipe recipe3 = new Recipe("Яйцо в хлебе", "Вырезать в хлебе отверстие, разбить яйцо, обжарить с двух сторон", list3);
        Recipe recipe4 = new Recipe("Яичница с овощами", "Обжарить лук и помидор, добавить яйца, жарить до готовности", list4);
        Recipe recipe5 = new Recipe("Омлет с начинкой", "Взбить яйца с молоком, добавить сыр и ветчину, жарить под крышкой до готовности", list5);
        Recipe recipe6 = new Recipe("Блинчики", "Смешать все ингредиенты, жарить на среднем огне, по 30 секунд с каждой стороны", list6);
        Recipe recipe7 = new Recipe("Пельмени", "Следуйте инструкции от производителя на упаковке", list7);
        // Сохраняем через jpa
        recipeService.saveRecipe(recipe1);
        recipeService.saveRecipe(recipe2);
        recipeService.saveRecipe(recipe3);
        recipeService.saveRecipe(recipe4);
        recipeService.saveRecipe(recipe5);
        recipeService.saveRecipe(recipe6);
        recipeService.saveRecipe(recipe7);

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