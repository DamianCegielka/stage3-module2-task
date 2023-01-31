package com.mjc.school.service.mapper;

import com.mjc.school.repository.entity.AuthorModel;
import com.mjc.school.service.dto.AuthorDtoResponse;
import org.mapstruct.Mapper;

@Mapper
public interface AuthorModelMapperToAuthorDtoResponse {
    AuthorDtoResponse map(AuthorModel authorModel);
}
