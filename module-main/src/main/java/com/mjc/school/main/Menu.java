package com.mjc.school.main;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.impl.command.*;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
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
    private final BaseController<NewsDtoRequest, NewsDtoResponse, Long> newsController;
    @Autowired
    private final BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> authorController;
    @Autowired
    private final Invoker invoker;

    private int chosenNumber = -1;

    public Menu(BaseController<NewsDtoRequest, NewsDtoResponse, Long> newsController,
                BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> authorController,
                Invoker invoker) {
        this.newsController = newsController;
        this.authorController = authorController;
        this.invoker=invoker;
    }

    public void mainController() throws IOException {

        try {
            while (chosenNumber != 0) {
                System.out.println(MENU_TEXT);
                chosenNumber = this.takeNumberFromKeyboard();
                switch (chosenNumber) {
                    case 1 -> invoker.setCommand(new CreateNewsCommand(newsController));
                    case 2 -> invoker.setCommand(new CreateAuthorCommand(authorController));
                    case 3 -> invoker.setCommand(new ReadAllNewsCommand(newsController));
                    case 4 -> invoker.setCommand(new ReadAllAuthorsCommand(authorController));
                    case 5 -> invoker.setCommand(new ReadNewsByIdCommand(newsController));
                    case 6 -> invoker.setCommand(new ReadAuthorByIdCommand(authorController));
                    case 7 -> invoker.setCommand(new UpdateNewsCommand(newsController));
                    case 8 -> invoker.setCommand(new UpdateAuthorCommand(authorController));
                    case 9 -> invoker.setCommand(new DeleteNewsByIdCommand(newsController));
                    case 10 ->invoker.setCommand(new DeleteAuthorByIdCommand(authorController));
                    case 0 -> System.out.println("By by!");
                    default -> System.out.println("Error!");
                }
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
