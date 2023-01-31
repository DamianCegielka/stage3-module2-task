package com.mjc.school.controller.impl.command;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.Command;
import com.mjc.school.controller.questions.AskQuestionsToGetNewsDtoRequestWithIndex;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;

import java.io.IOException;

import static com.mjc.school.controller.constans.Constants.UPDATE_NEWS;

public class UpdateNewsCommand implements Command {
    private final BaseController<NewsDtoRequest, NewsDtoResponse, Long> controller;
    private final AskQuestionsToGetNewsDtoRequestWithIndex question = new AskQuestionsToGetNewsDtoRequestWithIndex();

    public UpdateNewsCommand(BaseController<NewsDtoRequest, NewsDtoResponse, Long> controller) {
        this.controller = controller;
    }

    @Override
    public void execute() throws IOException {
        System.out.println(UPDATE_NEWS);
        controller.update(question.askQuestionsToGetNewsDtoRequestWithIndex());
    }
}
