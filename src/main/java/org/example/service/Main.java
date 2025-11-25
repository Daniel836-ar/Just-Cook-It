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

    @Autowired
    public Main(RecipeService recipeService , IngredientService ingredientService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }

    //наш новый main
    @Override
    public void run(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // получение ингредиентов (ну в данном случае их создание , но по логике получение)

        //овощи
        Ingredient ingredient_potato = ingredientService.findOrCreateIngredient("Картофель");
        Ingredient ingredient_onion = ingredientService.findOrCreateIngredient("Лук Репчатый");
        Ingredient ingredient_carrot = ingredientService.findOrCreateIngredient("Морковь");
        Ingredient ingredient_cucumber = ingredientService.findOrCreateIngredient("Огурец");
        Ingredient ingredient_BulgarianPepper = ingredientService.findOrCreateIngredient("Перец Болгарский");
        Ingredient ingredient_tomato = ingredientService.findOrCreateIngredient("Помидор");
        Ingredient ingredient_beet = ingredientService.findOrCreateIngredient("Свёкла");
        Ingredient ingredient_garlic = ingredientService.findOrCreateIngredient("Чеснок");

        //фрукты
        Ingredient ingredient_pineapple = ingredientService.findOrCreateIngredient("Ананас");
        Ingredient ingredient_orange = ingredientService.findOrCreateIngredient("Апельсин");
        Ingredient ingredient_banana = ingredientService.findOrCreateIngredient("Банан");
        Ingredient ingredient_grapes = ingredientService.findOrCreateIngredient("Виноград");
        Ingredient ingredient_paper = ingredientService.findOrCreateIngredient("Груша");
        Ingredient ingredient_lime = ingredientService.findOrCreateIngredient("Лайм");
        Ingredient ingredient_lemon = ingredientService.findOrCreateIngredient("Лимон");
        Ingredient ingredient_apple = ingredientService.findOrCreateIngredient("Яблоко");

        //Молочка
        Ingredient ingredient_yogurt = ingredientService.findOrCreateIngredient("Йогурт");
        Ingredient ingredient_kefir = ingredientService.findOrCreateIngredient("Кефир");
        Ingredient ingredient_margarine = ingredientService.findOrCreateIngredient("Маргарин");
        Ingredient ingredient_better = ingredientService.findOrCreateIngredient("Масло");
        Ingredient ingredient_milk = ingredientService.findOrCreateIngredient("Молоко");
        Ingredient ingredient_cream = ingredientService.findOrCreateIngredient("Сливки");
        Ingredient ingredient_sourCream = ingredientService.findOrCreateIngredient("Сметана");
        Ingredient ingredient_cheese = ingredientService.findOrCreateIngredient("Сыр");
        Ingredient ingredient_curd = ingredientService.findOrCreateIngredient("Творог");

        //мука
        Ingredient ingredient_amaranthFlour = ingredientService.findOrCreateIngredient("Мука Амарантовая");
        Ingredient ingredient_riceFlour = ingredientService.findOrCreateIngredient("Мука Кукурузная");
        Ingredient ingredient_wheatFlour = ingredientService.findOrCreateIngredient("Мука Пшеничная");
        Ingredient ingredient_cornFlour = ingredientService.findOrCreateIngredient("Мука Рисовая");

        //Мясо/Яйца
        Ingredient ingredient_beef = ingredientService.findOrCreateIngredient("Говядина");
        Ingredient ingredient_turkey = ingredientService.findOrCreateIngredient("Индейка");
        Ingredient ingredient_chicken = ingredientService.findOrCreateIngredient("Курица");
        Ingredient ingredient_pork = ingredientService.findOrCreateIngredient("Свинина");
        Ingredient ingredient_sausages = ingredientService.findOrCreateIngredient("Сосиски");
        Ingredient ingredient_chickenEgg = ingredientService.findOrCreateIngredient("Яйцо Куринное");
        Ingredient ingredient_quailEgg = ingredientService.findOrCreateIngredient("Яйцо Перепелиное");


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