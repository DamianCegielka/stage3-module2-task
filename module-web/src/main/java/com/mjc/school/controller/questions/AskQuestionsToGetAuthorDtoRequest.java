package com.mjc.school.controller.questions;

import com.mjc.school.service.dto.AuthorDtoRequest;

import static com.mjc.school.controller.constans.Constants.ENTER_AUTHOR_NAME;

public class AskQuestionsToGetAuthorDtoRequest {

    TakeStringFromKeyboard questionString =new TakeStringFromKeyboard();

    public AuthorDtoRequest askQuestionsToGetAuthorDtoRequest() {
        AuthorDtoRequest author = new AuthorDtoRequest();
        try {
            System.out.println(ENTER_AUTHOR_NAME);
            author.setName(questionString.takeStringFromKeyboard());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return author;
    }
}
