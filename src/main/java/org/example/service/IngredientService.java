package org.example.service;

import org.example.model.Ingredient;
import org.example.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;
    @Autowired
    IngredientService(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }
    // ВСЕ ИНГРИДИЕНТЫ ПОЛУЧАТЬ ОТСЮДА !!!!
    // метод либо отдаст ссылку на существующий ингредиент, либо создаст и сразу сохранит новый
    // НО !!!! если нужно узнать есть ли вообще в бд такой рецепт, нужно использовать findByName(name)
    public Ingredient findOrCreateIngredient(String name){
        String findName = name.toLowerCase(); // перевел в нижний регистр
        List<Ingredient> ingredients = ingredientRepository.findByName(findName);// поиск в бд
        if (ingredients.isEmpty()){// если такого ингредиента нет
            Ingredient newIngredient = new Ingredient(findName);
            ingredientRepository.save(newIngredient);// сохранение в бд
            return newIngredient;
        }else {
            return ingredients.getFirst();//если есть, вернёт первый из списка
        }

    }

    // вернут Ingredient если есть и null если такого ингредиента нет
    public Ingredient findByName(String name){
        
        List<Ingredient> ingredientFind = ingredientRepository.findByName(name);// поиск в бд
        if (ingredientFind.isEmpty()){// если такого ингредиента нет
            return null;
        }else {
            return ingredientFind.getFirst();//если есть, вернёт первый из списка
        }
    }

}
