package com.mjc.school.controller.questions;

import java.io.IOException;

import static com.mjc.school.controller.constans.Constants.ENTER_NEWS_ID;

public class TakeIdAuthor {

    TakeNumberFromKeyboard question=new TakeNumberFromKeyboard();
    public Long takeIdNews() throws IOException {
        System.out.println(ENTER_NEWS_ID);
        return Long.valueOf(question.takeNumberFromKeyboard());
    }

}
