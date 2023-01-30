package com.mjc.school.controller.impl.command;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.Command;
import com.mjc.school.controller.questions.AskQuestionsToGetNewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;

public class CreateNewsCommand implements Command {
    private static final String CREATE_NEWS = "Create news.";
    private final BaseController<NewsDtoRequest, NewsDtoResponse, Long> controller;
    private final AskQuestionsToGetNewsDtoRequest question;


    public CreateNewsCommand(BaseController<NewsDtoRequest, NewsDtoResponse, Long> controller,AskQuestionsToGetNewsDtoRequest question) {
        this.controller = controller;
        this.question= question;
    }

    @Override
    public void execute() {
        System.out.println(CREATE_NEWS);
        controller.create(question.askQuestionsToGetNewsDtoRequest());
    }
}

