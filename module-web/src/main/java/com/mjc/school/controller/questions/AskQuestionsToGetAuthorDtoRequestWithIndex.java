package com.mjc.school.controller.questions;

import com.mjc.school.service.dto.AuthorDtoRequest;

import java.io.IOException;

import static com.mjc.school.controller.constans.Constants.ENTER_AUTHOR_ID;

public class AskQuestionsToGetAuthorDtoRequestWithIndex {

    TakeNumberFromKeyboard question1=new TakeNumberFromKeyboard();
    AskQuestionsToGetAuthorDtoRequest question2=new AskQuestionsToGetAuthorDtoRequest();

    public AuthorDtoRequest askQuestionsToGetAuthorDtoRequestWithIndex() throws IOException {
        System.out.println(ENTER_AUTHOR_ID);
        Long index = Long.valueOf(question1.takeNumberFromKeyboard());
        AuthorDtoRequest authorDtoRequest = question2.askQuestionsToGetAuthorDtoRequest();
        authorDtoRequest.setId(index);
        return authorDtoRequest;
    }
}
