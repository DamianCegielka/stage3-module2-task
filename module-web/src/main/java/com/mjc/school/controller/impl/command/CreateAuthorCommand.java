package com.mjc.school.controller.impl.command;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.Command;
import com.mjc.school.controller.questions.AskQuestionsToGetAuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;

import static com.mjc.school.controller.constans.Constants.CREATE_AUTHOR;

public class CreateAuthorCommand implements Command {
    private final BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> controller;
    private final AskQuestionsToGetAuthorDtoRequest question=new AskQuestionsToGetAuthorDtoRequest();

    public CreateAuthorCommand(BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        System.out.println(CREATE_AUTHOR);
        controller.create(question.askQuestionsToGetAuthorDtoRequest());
    }
}
