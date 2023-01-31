package com.mjc.school.service.mapper;

import com.mjc.school.repository.entity.AuthorModel;
import com.mjc.school.service.dto.AuthorDtoRequest;
import org.mapstruct.Mapper;

@Mapper
public interface AuthorDtoRequestMapperToAuthorModel {
    AuthorModel map(AuthorDtoRequest authorDtoRequest);
    AuthorModel mapUpdate(AuthorDtoRequest authorDtoRequest);
}
