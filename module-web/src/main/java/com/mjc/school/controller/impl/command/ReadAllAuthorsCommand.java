package com.mjc.school.controller.impl.command;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.Command;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;

import static com.mjc.school.controller.constans.Constants.GET_ALL_AUTHORS;

public class ReadAllAuthorsCommand implements Command {

    private final BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> controller;

    public ReadAllAuthorsCommand(BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        System.out.println(GET_ALL_AUTHORS);
        controller.readAll();
    }
}
