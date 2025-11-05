package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadJson {

    public static List<String> getIngredientsFromJson(String recipeName) throws IOException, ParseException {
        String filePath = "src/main/java/jsons/resipes.json";

        Object readJsonIngredients = new JSONParser().parse(new FileReader(filePath));
        JSONArray recipes = (JSONArray) readJsonIngredients; // так как JSON — это массив объектов

        for (Object obj : recipes) {
            JSONObject recipeObj = (JSONObject) obj;
            String name = (String) recipeObj.get("name");

            if (name.equalsIgnoreCase(recipeName)) {
                JSONArray ingredientsArray = (JSONArray) recipeObj.get("ingredients");
                List<String> ingredients = new ArrayList<>();

                for (Object ingObj : ingredientsArray) {
                    JSONObject ing = (JSONObject) ingObj;
                    String ingName = (String) ing.get("name");
                    long qty = (Long) ing.get("quantity");
                    String unit = (String) ing.get("unit");

                    ingredients.add(ingName + " - " + qty + " " + unit);
                }

                return ingredients;
            }
        }

        return List.of(); // если рецепт не найден
    }
}
