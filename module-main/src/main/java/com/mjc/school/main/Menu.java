package com.mjc.school.main;

import com.mjc.school.controller.impl.command.CommandFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class Menu {

    private static final String MENU_TEXT =
            """
                    Enter the number of operation:
                    1 - Create news.
                    2 - Create author.
                    3 - Get all news.
                    4 - Get all authors.
                    5 - Get news by id.
                    6 - Get author by id.
                    7 - Update news.
                    8 - Update author.
                    9 - Remove news by id.
                    10 - Remove author by id.
                    0 - Exit.
                    """;


    @Autowired
    private final CommandFactory commandFactory;

    private int chosenNumber = -1;

    public Menu(CommandFactory commandFactory) {
        this.commandFactory=commandFactory;
    }

    public void mainController() throws IOException {

        try {
            while (chosenNumber != 0) {
                System.out.println(MENU_TEXT);
                chosenNumber = this.takeNumberFromKeyboard();
                commandFactory.mainController(chosenNumber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int takeNumberFromKeyboard() throws IOException {
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(bufferedreader.readLine());
    }

}
