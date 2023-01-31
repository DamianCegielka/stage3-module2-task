package com.mjc.school.controller.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.annotations.CommandHandler;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class NewsController implements BaseController<NewsDtoRequest, NewsDtoResponse, Long> {

    @Autowired
    public final BaseService<NewsDtoRequest, NewsDtoResponse, Long> service;

    public NewsController(BaseService<NewsDtoRequest, NewsDtoResponse, Long> service) {
        this.service = service;
    }

    @Override
    @CommandHandler(value = "createNews")
    public NewsDtoResponse create(NewsDtoRequest createRequest) { return service.create(createRequest);}

    @Override
    @CommandHandler(value = "readAllNews")
    public List<NewsDtoResponse> readAll() { return service.readAll(); }

    @Override
    @CommandHandler(value = "readNews")
    public NewsDtoResponse readById(Long id) {
        return service.readById(id);
    }

    @Override
    @CommandHandler(value = "updateNews")
    public NewsDtoResponse update(NewsDtoRequest updateRequest) {
        return service.update(updateRequest);
    }

    @Override
    @CommandHandler(value = "deleteNews")
    public boolean deleteById(Long id) {
        return service.deleteById(id);
    }
}
