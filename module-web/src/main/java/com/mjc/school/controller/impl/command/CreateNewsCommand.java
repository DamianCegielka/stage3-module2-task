package com.mjc.school.controller.impl.command;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.Command;
import com.mjc.school.controller.questions.AskQuestionsToGetNewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;

import static com.mjc.school.controller.constans.Constants.CREATE_NEWS;

public class CreateNewsCommand implements Command {
    private final BaseController<NewsDtoRequest, NewsDtoResponse, Long> controller;
    private final AskQuestionsToGetNewsDtoRequest question=new AskQuestionsToGetNewsDtoRequest();


    public CreateNewsCommand(BaseController<NewsDtoRequest, NewsDtoResponse, Long> controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        System.out.println(CREATE_NEWS);
        controller.create(question.askQuestionsToGetNewsDtoRequest());
    }
}

