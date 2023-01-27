package com.mjc.school.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.mjc.school");
        Menu menu=context.getBean(Menu.class);
        menu.mainController();
    }
}
