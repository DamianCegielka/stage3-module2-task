package com.mjc.school.controller.questions;

import com.mjc.school.service.dto.NewsDtoRequest;

import java.io.IOException;

import static com.mjc.school.controller.constans.Constants.ENTER_NEWS_ID;

public class AskQuestionsToGetNewsDtoRequestWithIndex {

    TakeNumberFromKeyboard question1= new TakeNumberFromKeyboard();
    AskQuestionsToGetNewsDtoRequest question2=new AskQuestionsToGetNewsDtoRequest();

    public NewsDtoRequest askQuestionsToGetNewsDtoRequestWithIndex() throws IOException {
        System.out.println(ENTER_NEWS_ID);
        Long index = Long.valueOf(question1.takeNumberFromKeyboard());
        NewsDtoRequest newsDtoRequest =question2.askQuestionsToGetNewsDtoRequest();
        newsDtoRequest.setId(index);
        return newsDtoRequest;
    }
}
