package org.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.lang.model.element.Name;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //листы ингридиентов
        List<Ingredient> list1 = new ArrayList<>(Arrays.asList(new Ingredient("яйцо","3 штуки"),new Ingredient("масло","капля")));
        List<Ingredient> list2 = new ArrayList<>(Arrays.asList(new Ingredient("пачка пельменей","ну ... вода , я хз"),new Ingredient("масло","капля")));
        List<Ingredient> list3 = new ArrayList<>(Arrays.asList(new Ingredient("доширак","воду ч толчка в чайник залей и норм будет"),new Ingredient("масло","капля")));

        Recipe recipe1 = new Recipe("Яишница","Яйца на сковороду разбиаешь и всё",list1);
        Recipe recipe2 = new Recipe("Пельмени","Следуй иснтрукции на пачке, я хз что ещё тебе сказать",list2);
        Recipe recipe3 = new Recipe("Доширак","Кипятком залей на 10 минут и всё",list3);

        // я пока хз как эти две строки работают
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.example");
        SessionFactory sessionFactory = context.getBean(SessionFactory.class);//именно от него создавать сессии !

        Session session = sessionFactory.openSession();//создание сессии

        session.beginTransaction();// открываем транзакцию , чтобы данные не терялись и бд не ломалась

        session.persist(recipe1);
        session.persist(recipe2);
        session.persist(recipe3);

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