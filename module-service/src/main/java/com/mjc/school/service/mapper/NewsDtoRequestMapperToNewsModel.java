package com.mjc.school.service.mapper;

import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.service.dto.NewsDtoRequest;
import org.mapstruct.Mapper;

@Mapper
public interface NewsDtoRequestMapperToNewsModel {

    NewsModel map(NewsDtoRequest request);

    NewsModel mapUpdate(NewsDtoRequest request);
}
