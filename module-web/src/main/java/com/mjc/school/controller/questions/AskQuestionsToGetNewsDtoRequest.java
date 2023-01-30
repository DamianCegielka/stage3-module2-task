package com.mjc.school.controller.questions;

import com.mjc.school.service.dto.NewsDtoRequest;

import static com.mjc.school.controller.constans.Constants.ENTER_AUTHOR_ID;
import static com.mjc.school.controller.constans.Constants.ENTER_TITLE;
import static com.mjc.school.controller.constans.Constants.ENTER_CONTENT;

public class AskQuestionsToGetNewsDtoRequest {

    TakeStringFromKeyboard questionString =new TakeStringFromKeyboard();
    TakeNumberFromKeyboard questionNumber =new TakeNumberFromKeyboard();

    public NewsDtoRequest askQuestionsToGetNewsDtoRequest() {
        NewsDtoRequest newsDtoRequest = new NewsDtoRequest();
        try {
            System.out.println(ENTER_TITLE);
            newsDtoRequest.setTitle(questionString.takeStringFromKeyboard());
            System.out.println(ENTER_CONTENT);
            newsDtoRequest.setContent(questionString.takeStringFromKeyboard());
            System.out.println(ENTER_AUTHOR_ID);
            newsDtoRequest.setAuthorId(Long.valueOf(questionNumber.takeNumberFromKeyboard()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsDtoRequest;
    }
}
