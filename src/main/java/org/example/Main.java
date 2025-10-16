package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Recipe recipe1 = new Recipe("Яишница","Яйца на сковороду разбиаешь и всё");
        Recipe recipe2 = new Recipe("Пельмени","Следуй иснтрукции на пачке, я хз что ещё тебе сказать");
        Recipe recipe3 = new Recipe("Доширак","Кипятком залей на 10 минут и всё");

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
        Recipe recipeFind = session.createQuery("SELECT s from Recipe s where s.id = 2",Recipe.class).getSingleResult();
        System.out.println(recipeFind);


        session.close();//ЭТА СТРОЧКА ОБЯЗАТЕЛЬНА В КОНЦЕ ДОЛЖНА БЫТЬ!!!

    }
}
