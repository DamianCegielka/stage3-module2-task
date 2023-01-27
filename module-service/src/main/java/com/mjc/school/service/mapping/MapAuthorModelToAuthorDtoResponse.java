package com.mjc.school.service.mapping;

import com.mjc.school.repository.entity.AuthorModel;
import com.mjc.school.service.dto.AuthorDtoResponse;

public class MapAuthorModelToAuthorDtoResponse {

    public AuthorDtoResponse map(AuthorModel authorModel){
        AuthorDtoResponse authorDtoResponse=new AuthorDtoResponse();
        authorDtoResponse.setId(authorModel.getId());
        authorDtoResponse.setName(authorModel.getName());
        authorDtoResponse.setCreateDate(authorModel.getCreateDate());
        authorDtoResponse.setLastUpdateTime((authorModel.getLastUpdateTime()));
        return authorDtoResponse;
    }
}
