package org.example.service;

import org.example.model.Ingredient;
import org.example.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    private IngredientRepository ingredientRepository;
    @Autowired
    IngredientService(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }
    // ВСЕ ИНГРИДИЕНТЫ ПОЛУЧАТЬ ОТСЮДА !!!!
    // метод либо отдаст ссылку на существующий ингредиент , либо создаст и сразу сохранит новый
    // НО !!!! если нужно узнать есть ли вообще в бд такой рецепт , нужно использовать findByName(name)
    public Ingredient findOrCreateIngredient(String name){
        List<Ingredient> ingredients = ingredientRepository.findByName(name);// поиск в бд
        if (ingredients.isEmpty()){// если такого ингредиента нет
            Ingredient newIngridient = new Ingredient(name);
            ingredientRepository.save(newIngridient);// сохранение в бд
            return newIngridient;
        }else {
            return ingredients.getFirst();//если есть , вернёт первый из списка
        }


    }

    // вернут Ingredient если есть и null если такого ингридиента нет
    public Ingredient findByName(String name){
        List<Ingredient> ingridientfind = ingredientRepository.findByName(name);// поиск в бд
        if (ingridientfind.isEmpty()){// если такого ингредиента нет
            return null;
        }else {
            return ingridientfind.getFirst();//если есть , вернёт первый из списка
        }
    }

}
