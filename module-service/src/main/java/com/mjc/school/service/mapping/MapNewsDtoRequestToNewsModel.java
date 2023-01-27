package com.mjc.school.service.mapping;

import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.service.dto.NewsDtoRequest;

public class MapNewsDtoRequestToNewsModel {

    public NewsModel map(NewsDtoRequest request){
        NewsModel newsModel=new NewsModel();
        newsModel.setTitle(request.getTitle());
        newsModel.setContent(request.getContent());
        newsModel.setAuthorId(request.getAuthorId());
        return newsModel;
    }
}
