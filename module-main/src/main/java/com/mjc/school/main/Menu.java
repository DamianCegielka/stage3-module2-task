package com.mjc.school.main;

import com.mjc.school.controller.BaseController;
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
    private static final String CREATE_NEWS = "Create news.";
    private static final String CREATE_AUTHOR = "Create author.";
    private static final String GET_ALL_NEWS = "Operation: Get all news.";
    private static final String GET_ALL_AUTHORS = "Operation: Get all authors.";
    private static final String GET_NEWS_ID = "Operation: Get news by id.";
    private static final String GET_AUTHOR_ID = "Operation: Get author by id.";
    private static final String ENTER_NEWS_ID = "Enter news id";
    private static final String ENTER_AUTHOR_ID = "Enter author id";
    private static final String ENTER_TITLE = "Enter news title:";
    private static final String ENTER_CONTENT = "Enter news content:";
    private static final String ENTER_AUTHOR_NAME = "Enter author name";
    private static final String UPDATE_NEWS = "Operation: Update news.";
    private static final String UPDATE_AUTHOR = "Operation: Update author.";
    private static final String REMOVE_NEWS = "Operation: Remove news by id.";
    private static final String REMOVE_AUTHOR = "Operation: Remove author by id.";

    @Autowired
    private final BaseController<NewsDtoRequest, NewsDtoResponse, Long> NewsController;
    @Autowired
    private final BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> AuthorController;

    private int chosenNumber = -1;

    public Menu(BaseController<NewsDtoRequest, NewsDtoResponse, Long> NewsController,
                BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> AuthorController) {
        this.NewsController = NewsController;
        this.AuthorController = AuthorController;
    }

    public void mainController() throws IOException {

        try {
            while (chosenNumber != 0) {
                System.out.println(MENU_TEXT);
                chosenNumber = this.takeNumberFromKeyboard();

                switch (chosenNumber) {
                    case 1 -> {
                        System.out.println(CREATE_NEWS);
                        NewsController.create(this.askQuestionsToGetNewsDtoRequest());
                    }
                    case 2 -> {
                        System.out.println(CREATE_AUTHOR);
                        AuthorController.create(this.askQuestionsToGetAuthorDtoRequest());
                    }
                    case 3 -> {
                        System.out.println(GET_ALL_NEWS);
                        NewsController.readAll();
                    }
                    case 4 -> {
                        System.out.println(GET_ALL_AUTHORS);
                        AuthorController.readAll();
                    }
                    case 5 -> {
                        System.out.println(GET_NEWS_ID);
                        NewsController.readById(this.takeIdNews());
                    }
                    case 6 -> {
                        System.out.println(GET_AUTHOR_ID);
                        AuthorController.readById(this.takeIdAuthor());
                    }
                    case 7 -> {
                        System.out.println(UPDATE_NEWS);
                        NewsController.update(this.askQuestionsToGetNewsDtoRequestWithIndex());
                    }
                    case 8 -> {
                        System.out.println(UPDATE_AUTHOR);
                        AuthorController.update(this.askQuestionsToGetAuthorDtoRequestWithIndex());
                    }
                    case 9 -> {
                        System.out.println(REMOVE_NEWS);
                        NewsController.deleteById(this.takeIdNews());
                    }
                    case 10 -> {
                        System.out.println(REMOVE_AUTHOR);
                        AuthorController.deleteById(this.takeIdNews());
                    }
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

    public String takeStringFromKeyboard() throws IOException {
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedreader.readLine();
    }

    public Long takeIdNews() throws IOException {
        System.out.println(ENTER_NEWS_ID);
        return Long.valueOf(takeNumberFromKeyboard());
    }

    public Long takeIdAuthor() throws IOException {
        System.out.println(ENTER_AUTHOR_ID);
        return Long.valueOf(takeNumberFromKeyboard());
    }

    public NewsDtoRequest askQuestionsToGetNewsDtoRequest() {
        NewsDtoRequest newsDtoRequest = new NewsDtoRequest();
        try {
            System.out.println(ENTER_TITLE);
            newsDtoRequest.setTitle(takeStringFromKeyboard());
            System.out.println(ENTER_CONTENT);
            newsDtoRequest.setContent(takeStringFromKeyboard());
            System.out.println(ENTER_AUTHOR_ID);
            newsDtoRequest.setAuthorId(Long.valueOf(takeNumberFromKeyboard()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsDtoRequest;
    }

    public AuthorDtoRequest askQuestionsToGetAuthorDtoRequest() {
        AuthorDtoRequest author = new AuthorDtoRequest();
        try {
            System.out.println(ENTER_AUTHOR_NAME);
            author.setName(takeStringFromKeyboard());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return author;
    }


    public NewsDtoRequest askQuestionsToGetNewsDtoRequestWithIndex() throws IOException {
        System.out.println(ENTER_NEWS_ID);
        Long index = Long.valueOf(takeNumberFromKeyboard());
        NewsDtoRequest newsDtoRequest = askQuestionsToGetNewsDtoRequest();
        newsDtoRequest.setId(index);
        System.out.println("MENU i zapisane id to: "+newsDtoRequest.getId());
        return newsDtoRequest;
    }

    public AuthorDtoRequest askQuestionsToGetAuthorDtoRequestWithIndex() throws IOException {
        System.out.println(ENTER_AUTHOR_ID);
        Long index = Long.valueOf(takeNumberFromKeyboard());
        AuthorDtoRequest authorDtoRequest = askQuestionsToGetAuthorDtoRequest();
        authorDtoRequest.setId(index);
        return authorDtoRequest;
    }
}
