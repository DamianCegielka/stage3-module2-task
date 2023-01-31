package com.mjc.school.controller.questions;

import static com.mjc.school.controller.constans.Constants.ENTER_NEWS_ID;

public class TakeIdNews {

    TakeNumberFromKeyboard questionNumber = new TakeNumberFromKeyboard();

    public Long takeIdNews() {
        try {
            System.out.println(ENTER_NEWS_ID);
            return Long.valueOf(questionNumber.takeNumberFromKeyboard());
        } catch (Exception e) {
        }
        return null;
    }
}
