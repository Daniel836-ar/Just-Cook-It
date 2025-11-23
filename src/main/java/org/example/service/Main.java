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
    private final IngredientService ingredientService;
    private  AmountService amountService = null;

    @Autowired
    public Main(RecipeService recipeService , IngredientService ingredientService, AmountService amountService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.amountService = amountService;
    }

    //наш новый main
    @Override
    public void run(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // получение ингредиентов (ну в данном случае их создание , но по логике получение)
        Ingredient ingredient = ingredientService.findOrCreateIngredient("Яйцо");
        Ingredient ingredient2 = ingredientService.findOrCreateIngredient("Яблоко");


        // Тестовые листы количества ингредиентов
        List<Amount> amounts1 = new ArrayList<>(Arrays.asList(new Amount(3,ingredient),new Amount(18,ingredient)));
        List<Amount> amounts2 = new ArrayList<>(Arrays.asList(new Amount(1,ingredient)));


        // создание рецептов
        Recipe recipe1 = new Recipe("Яишница", "Яйца на сковороду разбиаешь и всё", amounts1);
        Recipe recipe2 = new Recipe("фрукты с яйцом", "Следуй инструкции на пачке", amounts2);

        // Сохраняем через jpa сервис

        recipeService.saveRecipe(recipe1);
        recipeService.saveRecipe(recipe2);
   
        System.out.println("Тестовые данные сохранены");

        // ТЕСТ МЕТОДА getAll()
        System.out.println("\n=== Тестируем метод AmountService.getAll() ===");
        List<Amount> allAmounts = amountService.getAll();
        System.out.println("Всего Amount в базе: " + allAmounts.size());

        for (Amount amount : allAmounts) {
            System.out.println("Amount: id=" + amount.getId() +
                    ", количество=" + amount.getAmount() +
                    ", ингредиент=" + (amount.getIngredient() != null ? amount.getIngredient().getName() : "null") +
                    ", рецепт=" + (amount.getRecipe() != null ? amount.getRecipe().getName() : "null"));
        }


        //Здесь ты спрашиваешь у пользователя количество продуктов ------------------------------------

        List<Amount> availableAmounts = inputAvailableIngredients(scanner);

        // поиск (Здесь по названию, ты должен сделать по количеству продуктов)
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

    // метод для получения ингредиентов пользователя
    private List<Amount> inputAvailableIngredients(Scanner scanner) {
        List<Amount> availableAmounts = new ArrayList<>();

        while(true) {

            System.out.print("Введите название ингредиента (или 'стоп' для завершения): ");
           String name = scanner.nextLine();
            if(name.equals("стоп")) {
                break;
            }

            System.out.print("Введите количество: ");
            int amount = scanner.nextInt();
            scanner.nextLine();

            Ingredient ingredient = ingredientService.findOrCreateIngredient(name);
            availableAmounts.add(new Amount(amount, ingredient));
        }

        return availableAmounts;
    }
}