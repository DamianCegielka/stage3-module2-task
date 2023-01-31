package com.mjc.school.controller.impl.command;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.Command;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;

import static com.mjc.school.controller.constans.Constants.GET_ALL_NEWS;

public class ReadAllNewsCommand implements Command {
    private final BaseController<NewsDtoRequest, NewsDtoResponse, Long> controller;

    public ReadAllNewsCommand(BaseController<NewsDtoRequest, NewsDtoResponse, Long> controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        System.out.println(GET_ALL_NEWS);
        controller.readAll();
    }
}
