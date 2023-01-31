package com.mjc.school.controller.impl.command;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.Command;
import com.mjc.school.controller.questions.TakeIdNews;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;

import static com.mjc.school.controller.constans.Constants.GET_AUTHOR_ID;

public class ReadAuthorByIdCommand implements Command {

    private final BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> controller;
    private final TakeIdNews question = new TakeIdNews();

    public ReadAuthorByIdCommand(BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        System.out.println(GET_AUTHOR_ID);
        controller.readById(question.takeIdNews());
    }
}
