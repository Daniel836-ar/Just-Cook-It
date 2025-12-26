package org.example.service;

import org.example.model.Amount;
import org.example.model.Ingredient;
import org.example.model.Recipe;
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
    private final IngredientService ingredientService;
    private final RecipeSearchService recipeSearchService;
    private final AmountService amountService;

    @Autowired
    public Main(RecipeService recipeService , IngredientService ingredientService, AmountService amountService, RecipeSearchService recipeSearchService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.amountService = amountService;
        this.recipeSearchService = recipeSearchService;
    }

    @Override
    public void run(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // получение ингредиентов (ну в данном случае их создание , но по логике получение)
        //овощи
        Ingredient ingredient_potato = ingredientService.findOrCreateIngredient("Картофель","гр");
        Ingredient ingredient_tomato = ingredientService.findOrCreateIngredient("Помидор","шт");
        Ingredient ingredient_cucumber = ingredientService.findOrCreateIngredient("Огурец","шт");


        Ingredient ingredient_pasta = ingredientService.findOrCreateIngredient("Лапша","гр");
        Ingredient ingredient_macaroni = ingredientService.findOrCreateIngredient("Макароны","гр");
        Ingredient ingredient_amaranthFlour = ingredientService.findOrCreateIngredient("Мука","гр");

//Яйца
        Ingredient ingredient_chickenEgg = ingredientService.findOrCreateIngredient("Яйцо Куринное","шт");

//крупы
        Ingredient ingredient_rice = ingredientService.findOrCreateIngredient("Рис","гр");
        Ingredient ingredient_buckwheat = ingredientService.findOrCreateIngredient("Гречка","гр");


        //рецепты для проверки----------------------------------------------------
        List<Amount> amount_fried_eggs = new ArrayList<>(Arrays.asList(new Amount(3, ingredient_chickenEgg)));
        List<Amount> amount_eggs_and_grechka = new ArrayList<>(Arrays.asList(new Amount(1, ingredient_chickenEgg),new Amount(500, ingredient_buckwheat)));
        List<Amount> amount_eggs_and_rice = new ArrayList<>(Arrays.asList(new Amount(2, ingredient_chickenEgg),new Amount(500, ingredient_rice)));
        List<Amount> amount_eggs_and_tomato = new ArrayList<>(Arrays.asList(new Amount(2, ingredient_chickenEgg),new Amount(1, ingredient_tomato)));
        List<Amount> amount_tomatos_and_cucumbers = new ArrayList<>(Arrays.asList(new Amount(2, ingredient_tomato), new Amount(2, ingredient_cucumber)));
        List<Amount> amount_grechka_and_vegetables = new ArrayList<>(Arrays.asList(new Amount(500, ingredient_buckwheat), new Amount(1, ingredient_cucumber), new Amount(1,ingredient_tomato)));

        Recipe recipe_fried_eggs = new Recipe("Яишница","Три яйца на сковороду и жарить на среднем огне 5 минут", amount_fried_eggs);
        Recipe recipe_eggs_and_grechka = new Recipe("Яйца с гречкой","одно яйцо на сковороду и жарить на среднем огне 5 минут, а потом добавить готовую гречку", amount_eggs_and_grechka);
        Recipe recipe_eggs_andrice = new Recipe("Яйца с рисом","два яйца на сковороду и жарить на среднем огне 5 минут, а потом добавить готовый рис", amount_eggs_and_rice);
        Recipe recipe_eggs_and_tomato = new Recipe("Яйца с помидором","Три яйца и один помидор на сковороду, и жарить на среднем огне 5 минут", amount_eggs_and_tomato);
        Recipe recipe_tomato_and_cucumbers = new Recipe("салат из огурцов и помидоров","Произвольно нарезаем огурцы и помидоры , кладём все", amount_tomatos_and_cucumbers);
        Recipe recipe_grechka_vegetables = new Recipe("Гречка с овощами","Варим гречку , а после добавляем мелко нарезанные кусочки огурца и помидорки", amount_grechka_and_vegetables);


        //----------------------------------------------------

        recipeService.saveRecipe(recipe_fried_eggs );
        recipeService.saveRecipe(recipe_eggs_and_grechka );
        recipeService.saveRecipe(recipe_eggs_andrice );
        recipeService.saveRecipe(recipe_eggs_and_tomato );
        recipeService.saveRecipe(recipe_tomato_and_cucumbers );
        recipeService.saveRecipe(recipe_grechka_vegetables );


        //----------------------------------------------------

        //Здесь спрашиваем у пользователя количество продуктов ------------------------------------

        List<Amount> availableAmounts = inputAvailableIngredients(scanner);

        // Поиск рецептов
        System.out.println("\n--- Поиск рецептов по ингредиентам ---");
        List<Recipe> foundRecipes = recipeSearchService.findByIngredients(availableAmounts);

        // Результат
        if (foundRecipes.isEmpty()) {
            System.out.println("Не найдено рецептов для ваших ингредиентов");
        } else {
            System.out.println("Найдено рецептов: " + foundRecipes.size());
            for (Recipe recipe : foundRecipes) {
                System.out.println(" - " + recipe.getName()+", инструкция по приготовлению: "+ recipe.getInstructions());
            }
        }

        scanner.close();

        // Завершаем работу
        System.exit(0);
    }

    // метод для получения ингредиентов пользователя
    private List<Amount> inputAvailableIngredients(Scanner scanner) {
        List<Amount> availableAmounts = new ArrayList<>();
        System.out.println("\n--- Поиск рецептов по ингредиентам ---");
        while(true) {
            System.out.print("Введите название ингредиента (или 'стоп' для завершения): ");
            String name = scanner.nextLine().trim();

            if(name.equalsIgnoreCase("стоп")) {
                break;
            }

            if(name.isEmpty()) {
                System.out.println("Название не может быть пустым!");
                continue;
            }

            String normalizedName = name.toLowerCase().trim();
            Ingredient ingredient = ingredientService.findByName(normalizedName);

            if (ingredient == null) {
                System.out.println("Ингредиент '" + normalizedName + "' не найден в базе данных.");
                continue;
            }


            System.out.print("Введите количество, "+ "данный ингредиент измеряется в "+ingredient.getMeasured()+": ");
            if (!scanner.hasNextInt()) {
                System.out.println("Пожалуйста, введите целое число!");
                scanner.next(); // очищаем некорректный ввод
                continue;
            }

            int amount = scanner.nextInt();
            scanner.nextLine(); // очищаем буфер

            if (amount <= 0) {
                System.out.println("Количество должно быть положительным числом!");
                continue;
            }

            availableAmounts.add(new Amount(amount, ingredient));

            System.out.println("Добавлен ингредиент: " + normalizedName + " - " + amount +" "+ ingredient.getMeasured());
        }

        return availableAmounts;
    }
}