package com.mjc.school.controller.constans;

public class Constants {

    private Constants(){
    }

    public static final String MENU_TEXT =
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
    public static final String CREATE_NEWS = "Create news.";
    public static final String CREATE_AUTHOR = "Create author.";
    public static final String GET_ALL_NEWS = "Operation: Get all news.";
    public static final String GET_ALL_AUTHORS = "Operation: Get all authors.";
    public static final String GET_NEWS_ID = "Operation: Get news by id.";
    public static final String GET_AUTHOR_ID = "Operation: Get author by id.";
    public static final String ENTER_NEWS_ID = "Enter news id";
    public static final String ENTER_AUTHOR_ID = "Enter author id";
    public static final String ENTER_TITLE = "Enter news title:";
    public static final String ENTER_CONTENT = "Enter news content:";
    public static final String ENTER_AUTHOR_NAME = "Enter author name";
    public static final String UPDATE_NEWS = "Operation: Update news.";
    public static final String REMOVE_NEWS = "Operation: Remove news by id.";
    public static final String REMOVE_AUTHOR = "Operation: Remove author by id.";
}
