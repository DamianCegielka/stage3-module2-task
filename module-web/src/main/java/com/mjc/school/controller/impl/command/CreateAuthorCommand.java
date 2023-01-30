package com.mjc.school.controller.impl.command;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.Command;
import com.mjc.school.controller.questions.AskQuestionsToGetAuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;

public class CreateAuthorCommand implements Command {
    private static final String CREATE_AUTHOR = "Create author.";
    private final BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> controller;
    private final AskQuestionsToGetAuthorDtoRequest question;

    public CreateAuthorCommand(BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> controller,
                               AskQuestionsToGetAuthorDtoRequest question) {
        this.controller = controller;
        this.question = question;
    }

    @Override
    public void execute() {
        System.out.println(CREATE_AUTHOR);
        controller.create(question.askQuestionsToGetAuthorDtoRequest());
    }
}
