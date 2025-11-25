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
        Ingredient ingredient_garlic = ingredientService.findOrCreateIngredient("Чеснок (зубчик)");

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
        Ingredient ingredient_pasta = ingredientService.findOrCreateIngredient("Лапша (гр)");
        Ingredient ingredient_macaroni = ingredientService.findOrCreateIngredient("Макароны (гр)");
        Ingredient ingredient_amaranthFlour = ingredientService.findOrCreateIngredient("Мука Амарантовая (гр)");
        Ingredient ingredient_riceFlour = ingredientService.findOrCreateIngredient("Мука Кукурузная (гр)");
        Ingredient ingredient_wheatFlour = ingredientService.findOrCreateIngredient("Мука Пшеничная (гр)");
        Ingredient ingredient_cornFlour = ingredientService.findOrCreateIngredient("Мука Рисовая (гр)");
        Ingredient ingredient_spaghetti = ingredientService.findOrCreateIngredient("Спагетти (гр)");

        //Мясо|Яйца
        Ingredient ingredient_bacon = ingredientService.findOrCreateIngredient("Бекон (гр)");
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

        //крупы
        Ingredient ingredient_rice = ingredientService.findOrCreateIngredient("Рис (гр)");
        Ingredient ingredient_buckwheat = ingredientService.findOrCreateIngredient("Гречка (гр)");
        Ingredient ingredient_oatmeal = ingredientService.findOrCreateIngredient("Овсянка (гр)");
        Ingredient ingredient_millet = ingredientService.findOrCreateIngredient("Пшено (гр)");
        Ingredient ingredient_semolina = ingredientService.findOrCreateIngredient("Манная крупа (гр)");
        Ingredient ingredient_pearlBarley = ingredientService.findOrCreateIngredient("Перловка (гр)");

        //вода|масло
        Ingredient ingredient_water = ingredientService.findOrCreateIngredient("Вода (мл)");
        Ingredient ingredient_oil = ingredientService.findOrCreateIngredient("Масло Подсолнечное (мл)");

        //приправы|соусы
        Ingredient ingredient_basil = ingredientService.findOrCreateIngredient("Базилик (гр)");
        Ingredient ingredient_yeasts = ingredientService.findOrCreateIngredient("Дрожжи (гр)");
        Ingredient ingredient_ketchup = ingredientService.findOrCreateIngredient("Кетчуп (гр)");
        Ingredient ingredient_mayonnaise = ingredientService.findOrCreateIngredient("Майонез (гр)");
        Ingredient ingredient_sugar = ingredientService.findOrCreateIngredient("Сахар (гр)");
        Ingredient ingredient_solt = ingredientService.findOrCreateIngredient("Соль (гр)");
        Ingredient ingredient_tomatoPaste = ingredientService.findOrCreateIngredient("Томатная Паста (гр)");


        // Тестовые листы количества ингредиентов
        List<Amount> amounts_PastaCarbonara = new ArrayList<>(Arrays.asList(
                new Amount(400,ingredient_spaghetti),new Amount(150,ingredient_bacon),
                new Amount(100,ingredient_cheese),new Amount(4,ingredient_chickenEgg),
                new Amount(100,ingredient_cream),new Amount(2,ingredient_garlic)
        ));
        List<Amount> amounts_Pilaf = new ArrayList<>(Arrays.asList(
                new Amount(500,ingredient_rice),new Amount(600,ingredient_pork),
                new Amount(300,ingredient_carrot),new Amount(200,ingredient_onion),
                new Amount(6,ingredient_garlic),new Amount(200,ingredient_onion),
                new Amount(6,ingredient_water)
        ));
        List<Amount> amounts_PizzaMargherita = new ArrayList<>(Arrays.asList(
                new Amount(500,ingredient_wheatFlour),new Amount(300,ingredient_water),
                new Amount(7,ingredient_yeasts),new Amount(10,ingredient_solt),
                new Amount(10,ingredient_sugar),new Amount(30,ingredient_oil),
                new Amount(250,ingredient_cheese),new Amount(300,ingredient_tomato),
                new Amount(150,ingredient_tomatoPaste),new Amount(20,ingredient_basil),
                new Amount(20,ingredient_oil)
        ));
        List<Amount> amounts_ChickenWithPotatoes = new ArrayList<>(Arrays.asList(
                new Amount(500,ingredient_rice),new Amount(600,ingredient_pork),
                new Amount(300,ingredient_carrot),new Amount(200,ingredient_onion),
                new Amount(6,ingredient_garlic),new Amount(200,ingredient_onion),
                new Amount(6,ingredient_water)
        ));
        List<Amount> amounts_Borscht = new ArrayList<>(Arrays.asList(
                new Amount(500,ingredient_rice),new Amount(600,ingredient_pork),
                new Amount(300,ingredient_carrot),new Amount(200,ingredient_onion),
                new Amount(6,ingredient_garlic),new Amount(200,ingredient_onion),
                new Amount(6,ingredient_water)
        ));


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