package com.mjc.school.service.mapping;

import com.mjc.school.repository.entity.AuthorModel;
import com.mjc.school.service.dto.AuthorDtoRequest;

public class MapAuthorDtoRequestToAuthorModel {

    public AuthorModel map(AuthorDtoRequest request) {
        AuthorModel authorModel = new AuthorModel();
        authorModel.setId(request.getId());
        authorModel.setName(request.getName());
        return authorModel;
    }

    public AuthorModel mapUpdate(AuthorDtoRequest request) {
        AuthorModel authorModel = new AuthorModel("empty");
        authorModel.setId(request.getId());
        authorModel.setName(request.getName());
        return authorModel;
    }
}
