package org.example;
import java.io.IOException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.lang.model.element.Name;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);


        List<String> FriedEggsIngredients = ReadJson.getIngredientsFromJson("FriedEggs");
        List<String> DumplingsIngredients = ReadJson.getIngredientsFromJson("Dumplings");
        List<String> DoshirakIngredients = ReadJson.getIngredientsFromJson("Doshirak");
        List<String> plovIngredients = ReadJson.getIngredientsFromJson("PlovGoviadina");
        List<String> soupIngredients = ReadJson.getIngredientsFromJson("ChickenSoup");

        Recipe recipe1 = new Recipe("Яишница","Яйца на сковороду разбиаешь и всё", FriedEggsIngredients);
        Recipe recipe2 = new Recipe("Пельмени","Следуй иснтрукции на пачке, я хз что ещё тебе сказать", DumplingsIngredients);
        Recipe recipe3 = new Recipe("Доширак","Кипятком залей на 10 минут и всё", DoshirakIngredients);
        Recipe recipe4 = new Recipe("Плов с говядиной","Обжарьте свинину с луком и морковью, залейте водой, добавьте промытый рис и тушите под крышкой на медленном огне до готовности.", plovIngredients);
        Recipe recipe5 = new Recipe("Куринный суп","Обжарьте курицу с овощами, залейте водой, добавьте картофель и вермишель, варите до готовности всех ингредиентов.", soupIngredients);


        // я пока хз как эти две строки работают
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.example");
         SessionFactory sessionFactory = context.getBean(SessionFactory.class);//именно от него создавать сессии !

        Session session = sessionFactory.openSession();//создание сессии

        session.beginTransaction();// открываем транзакцию , чтобы данные не терялись и бд не ломалась

        session.persist(recipe1);
        session.persist(recipe2);
        session.persist(recipe3);
        session.persist(recipe4);
        session.persist(recipe5);


        session.getTransaction().commit();//ЗАКРЫТИЕ ТРАНЗАКЦИИ !!!


        //простенькое обращение
        String nameFind = scanner.nextLine();

        List <Recipe> recipeFind = session.createQuery("SELECT s from Recipe s where s.name = :Name",Recipe.class).setParameter("Name",nameFind).getResultList();
        scanner.close();
        if(recipeFind.size()==0){
            System.out.println("Не нашли такого рецепта");
        }else {
            for (Recipe recipe : recipeFind) {
                System.out.println(recipeFind);
            }
        }


        session.close();//ЭТА СТРОЧКА ОБЯЗАТЕЛЬНА В КОНЦЕ ДОЛЖНА БЫТЬ!!!

    }
}
