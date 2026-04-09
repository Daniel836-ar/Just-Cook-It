package org.example.converter;


import org.example.model.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToIngredientConverter implements Converter<String, Ingredient> {

    @Override
    public Ingredient convert(String s) {
        return new Ingredient();
    }
}
