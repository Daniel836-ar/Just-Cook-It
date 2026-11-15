package org.example.recipe.converter;


import lombok.extern.slf4j.Slf4j;
import org.example.recipe.model.Ingredient;
import org.example.recipe.service.IngredientService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StringToIngredientConverter implements Converter<String, Ingredient> {
    private IngredientService ingredientService;

    public StringToIngredientConverter(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Override
    public Ingredient convert(String s) {
        Ingredient searchIngredient;
        searchIngredient = ingredientService.findByName(s);
        if(searchIngredient!=null){
            log.info("Нашёл ингердиент "+ s);
            return searchIngredient;
        }else{
            log.info("Не нашли ингердиент "+ s);
            return null;
        }
    }
}
