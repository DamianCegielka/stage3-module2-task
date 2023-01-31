package com.mjc.school.controller.impl.command;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.Command;
import com.mjc.school.controller.questions.TakeIdNews;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;

import static com.mjc.school.controller.constans.Constants.REMOVE_AUTHOR;

public class DeleteAuthorByIdCommand implements Command {
    private final BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> controller;
    private final TakeIdNews question=new TakeIdNews();

    public DeleteAuthorByIdCommand(BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        System.out.println(REMOVE_AUTHOR);
        controller.deleteById(question.takeIdNews());
    }
}
