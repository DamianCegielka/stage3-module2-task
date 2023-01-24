package com.mjc.school.controller.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.repository.dto.NewsModelRequestWithIndex;
import com.mjc.school.repository.dto.NewsModelResponse;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoRequestWithIndex;
import com.mjc.school.service.dto.NewsDtoResponse;
import com.mjc.school.service.impl.BaseServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class BaseControllerImpl implements BaseController<NewsModelRequestWithIndex, NewsModelResponse, Long> {

    private static final String MENU_TEXT =
            """
                    Enter the number of operation:
                    1 - Get all news.
                    2 - Get news by id.
                    3 - Create news.
                    4 - Update news.
                    5 - Remove news by id.
                    0 - Exit.
                    """;

    private static final String GET_ALL_NEWS = "Operation: Get all news.";
    private static final String GET_NEWS_ID = "Operation: Get news by id.";
    private static final String ENTER_NEWS_ID = "Enter news id";
    private static final String ENTER_TITLE = "Enter news title:";
    private static final String ENTER_CONTENT = "Enter news content:";
    private static final String ENTER_AUTHOR_ID = "Enter author id";
    private static final String CREATE_NEWS = "Create news.";
    private static final String UPDATE_NEWS = "Operation: Update news.";
    private static final String REMOVE_NEWS = "Operation: Remove news by id.";

    private final BaseService controllerServiceDto = new BaseServiceImpl();

    private int chosenNumber = -1;

    public void mainController() throws IOException {

        controllerServiceDto.readAll();
        try {
            while (chosenNumber != 0) {
                System.out.println(MENU_TEXT);
                chosenNumber = takeNumberFromKeyboard();

                switch (chosenNumber) {
                    case 1 -> {
                        System.out.println(GET_ALL_NEWS);
                        this.readAllNews();
                    }
                    case 2 -> {
                        System.out.println(GET_NEWS_ID);
                        this.readByIdNews(this.takeIdNews());
                    }
                    case 3 -> {
                        System.out.println(CREATE_NEWS);
                        this.createNews(this.askQuestionsToGetDtoRequest());
                    }
                    case 4 -> {
                        System.out.println(UPDATE_NEWS);
                        this.updateNews(this.askQuestionsTOGetDtoRequestWithIndex());
                    }
                    case 5 -> {
                        System.out.println(REMOVE_NEWS);
                        this.deleteNews(this.takeIdNews());
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


    public NewsDtoRequest askQuestionsToGetDtoRequest() {
        NewsDtoRequest newsDTOCreation = new NewsDtoRequest();
        try {
            System.out.println(ENTER_TITLE);
            newsDTOCreation.setTitle(takeStringFromKeyboard());
            System.out.println(ENTER_CONTENT);
            newsDTOCreation.setContent(takeStringFromKeyboard());
            System.out.println(ENTER_AUTHOR_ID);
            newsDTOCreation.setAuthorId(Long.valueOf(takeNumberFromKeyboard()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsDTOCreation;
    }


    public NewsDtoRequestWithIndex askQuestionsTOGetDtoRequestWithIndex() throws IOException {
        System.out.println(ENTER_NEWS_ID);
        Long index = Long.valueOf(takeNumberFromKeyboard());
        NewsDtoRequest newsModelRequest = askQuestionsToGetDtoRequest();
        NewsDtoRequestWithIndex newsDtoRequestWithIndex = new NewsDtoRequestWithIndex();
        newsDtoRequestWithIndex.setId(index);
        newsDtoRequestWithIndex.setTitle(newsModelRequest.getTitle());
        newsDtoRequestWithIndex.setContent(newsModelRequest.getContent());
        newsDtoRequestWithIndex.setAuthorId(newsModelRequest.getAuthorId());
        return newsDtoRequestWithIndex;
    }


    public List<NewsDtoResponse> readAllNews() throws IOException {
        return controllerServiceDto.readAll();
    }


    public NewsDtoResponse readByIdNews(Long index) {
        NewsDtoResponse newsDtoResponse = new NewsDtoResponse();
        try {
            newsDtoResponse = (NewsDtoResponse) controllerServiceDto.readById(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsDtoResponse;
    }


    public NewsDtoResponse createNews(NewsDtoRequest newsDtoRequest) {
        NewsDtoResponse newsDtoResponse = new NewsDtoResponse();
        try {
            newsDtoResponse = (NewsDtoResponse) controllerServiceDto.create(newsDtoRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsDtoResponse;
    }


    public NewsDtoResponse updateNews(NewsDtoRequestWithIndex newsDtoRequestWithIndex) {
        NewsDtoResponse newsDtoResponse = new NewsDtoResponse();
        try {
            newsDtoResponse = (NewsDtoResponse) controllerServiceDto.update(newsDtoRequestWithIndex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsDtoResponse;
    }


    public Boolean deleteNews(Long index) {
        Boolean result = false;
        try {
            result = controllerServiceDto.deleteById(index);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<NewsModelResponse> readAll() {
        return null;
    }

    @Override
    public NewsModelResponse readById(Long id) {
        return null;
    }

    @Override
    public NewsModelResponse create(NewsModelRequestWithIndex createRequest) {
        return null;
    }

    @Override
    public NewsModelResponse update(NewsModelRequestWithIndex updateRequest) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
