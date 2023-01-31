package com.mjc.school.controller.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.annotations.CommandHandler;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorController implements BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> {

    @Autowired
    public final BaseService<AuthorDtoRequest, AuthorDtoResponse, Long> service;

    public AuthorController(BaseService<AuthorDtoRequest, AuthorDtoResponse, Long> service) {
        this.service = service;
    }

    @Override
    @CommandHandler(value = "readAllAuthors")
    public List<AuthorDtoResponse> readAll() {
        return service.readAll();
    }

    @Override
    @CommandHandler(value = "readAuthor")
    public AuthorDtoResponse readById(Long id) { return service.readById(id); }

    @Override
    @CommandHandler(value = "createAuthor")
    public AuthorDtoResponse create(AuthorDtoRequest createRequest) { return service.create(createRequest); }

    @Override
    @CommandHandler(value = "updateAuthor")
    public AuthorDtoResponse update(AuthorDtoRequest updateRequest) {
        return service.update(updateRequest);
    }

    @Override
    @CommandHandler(value = "deleteAuthor")
    public boolean deleteById(Long id) {
        return service.deleteById(id);
    }
}
