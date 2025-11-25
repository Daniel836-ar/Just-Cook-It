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
        Ingredient ingredient_potato = ingredientService.findOrCreateIngredient("Картофель (гр)");
        Ingredient ingredient_onion = ingredientService.findOrCreateIngredient("Лук Репчатый (гр)");
        Ingredient ingredient_carrot = ingredientService.findOrCreateIngredient("Морковь (гр)");
        Ingredient ingredient_cucumber = ingredientService.findOrCreateIngredient("Огурец (шт)");
        Ingredient ingredient_BulgarianPepper = ingredientService.findOrCreateIngredient("Перец Болгарский (гр)");
        Ingredient ingredient_tomato = ingredientService.findOrCreateIngredient("Помидор (шт)");
        Ingredient ingredient_beet = ingredientService.findOrCreateIngredient("Свёкла (гр)");
        Ingredient ingredient_garlic = ingredientService.findOrCreateIngredient("Чеснок (шт)");

        //фрукты
        Ingredient ingredient_pineapple = ingredientService.findOrCreateIngredient("Ананас (гр)");
        Ingredient ingredient_orange = ingredientService.findOrCreateIngredient("Апельсин (гр)");
        Ingredient ingredient_banana = ingredientService.findOrCreateIngredient("Банан (гр)");
        Ingredient ingredient_grapes = ingredientService.findOrCreateIngredient("Виноград (гр)");
        Ingredient ingredient_paper = ingredientService.findOrCreateIngredient("Груша (гр)");
        Ingredient ingredient_lime = ingredientService.findOrCreateIngredient("Лайм (гр)");
        Ingredient ingredient_lemon = ingredientService.findOrCreateIngredient("Лимон (гр)");
        Ingredient ingredient_apple = ingredientService.findOrCreateIngredient("Яблоко (гр)");

        //молочка
        Ingredient ingredient_yogurt = ingredientService.findOrCreateIngredient("Йогурт (мл)");
        Ingredient ingredient_kefir = ingredientService.findOrCreateIngredient("Кефир (мл)");
        Ingredient ingredient_margarine = ingredientService.findOrCreateIngredient("Маргарин (гр)");
        Ingredient ingredient_better = ingredientService.findOrCreateIngredient("Масло (гр)");
        Ingredient ingredient_milk = ingredientService.findOrCreateIngredient("Молоко (мл)");
        Ingredient ingredient_cream = ingredientService.findOrCreateIngredient("Сливки (гр)");
        Ingredient ingredient_sourCream = ingredientService.findOrCreateIngredient("Сметана (гр)");
        Ingredient ingredient_cheese = ingredientService.findOrCreateIngredient("Сыр (гр)");
        Ingredient ingredient_curd = ingredientService.findOrCreateIngredient("Творог (гр)");

        //мука
        Ingredient ingredient_amaranthFlour = ingredientService.findOrCreateIngredient("Мука Амарантовая (гр)");
        Ingredient ingredient_riceFlour = ingredientService.findOrCreateIngredient("Мука Кукурузная (гр)");
        Ingredient ingredient_wheatFlour = ingredientService.findOrCreateIngredient("Мука Пшеничная (гр)");
        Ingredient ingredient_cornFlour = ingredientService.findOrCreateIngredient("Мука Рисовая (гр)");

        //Мясо/Яйца
        Ingredient ingredient_beef = ingredientService.findOrCreateIngredient("Говядина (гр)");
        Ingredient ingredient_turkey = ingredientService.findOrCreateIngredient("Индейка (гр)");
        Ingredient ingredient_chicken = ingredientService.findOrCreateIngredient("Курица (гр)");
        Ingredient ingredient_pork = ingredientService.findOrCreateIngredient("Свинина (гр)");
        Ingredient ingredient_sausages = ingredientService.findOrCreateIngredient("Сосиски (шт)");
        Ingredient ingredient_chickenEgg = ingredientService.findOrCreateIngredient("Яйцо Куринное (шт)");
        Ingredient ingredient_quailEgg = ingredientService.findOrCreateIngredient("Яйцо Перепелиное (шт)");

        //рыба
        Ingredient ingredient_salmon = ingredientService.findOrCreateIngredient("Лосось (гр)");
        Ingredient ingredient_halibut = ingredientService.findOrCreateIngredient("Палтус (гр)");
        Ingredient ingredient_cod = ingredientService.findOrCreateIngredient("Треска (гр)");
        Ingredient ingredient_tuna = ingredientService.findOrCreateIngredient("Тунец (гр)");
        Ingredient ingredient_trout = ingredientService.findOrCreateIngredient("Форель (гр)");

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