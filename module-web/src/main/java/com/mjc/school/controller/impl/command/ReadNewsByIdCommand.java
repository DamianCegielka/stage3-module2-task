package com.mjc.school.controller.impl.command;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.Command;
import com.mjc.school.controller.questions.TakeIdNews;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;

import static com.mjc.school.controller.constans.Constants.GET_NEWS_ID;

public class ReadNewsByIdCommand implements Command {
    private final BaseController<NewsDtoRequest, NewsDtoResponse, Long> controller;
    private final TakeIdNews question = new TakeIdNews();

    public ReadNewsByIdCommand(BaseController<NewsDtoRequest, NewsDtoResponse, Long> controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        System.out.println(GET_NEWS_ID);
        controller.readById(question.takeIdNews());
    }
}
