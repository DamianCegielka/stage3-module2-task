package com.mjc.school.service.mapper;

import com.mjc.school.repository.entity.AuthorModel;
import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import org.springframework.stereotype.Component;

public class ModelDtoMapper {
    public static class MapAuthorDtoRequestToAuthorModel implements AuthorDtoRequestMapperToAuthorModel {

        @Override
        public AuthorModel map(AuthorDtoRequest request) {
            AuthorModel authorModel = new AuthorModel();
            authorModel.setId(request.getId());
            authorModel.setName(request.getName());
            return authorModel;
        }
        @Override
        public AuthorModel mapUpdate(AuthorDtoRequest request) {
            AuthorModel authorModel = new AuthorModel("empty");
            authorModel.setId(request.getId());
            authorModel.setName(request.getName());
            return authorModel;
        }
    }

    public static class MapAuthorModelToAuthorDtoResponse implements AuthorModelMapperToAuthorDtoResponse {

        @Override
        public AuthorDtoResponse map(AuthorModel authorModel){
            AuthorDtoResponse authorDtoResponse=new AuthorDtoResponse();
            authorDtoResponse.setId(authorModel.getId());
            authorDtoResponse.setName(authorModel.getName());
            authorDtoResponse.setCreateDate(authorModel.getCreateDate());
            authorDtoResponse.setLastUpdateTime((authorModel.getLastUpdateTime()));
            return authorDtoResponse;
        }
    }

    public static class MapNewsDtoRequestToNewsModel implements NewsDtoRequestMapperToNewsModel {

        @Override
        public NewsModel map(NewsDtoRequest request){
            NewsModel newsModel=new NewsModel();
            newsModel.setTitle(request.getTitle());
            newsModel.setContent(request.getContent());
            newsModel.setAuthorId(request.getAuthorId());
            return newsModel;
        }

        @Override
        public NewsModel mapUpdate(NewsDtoRequest request){
            NewsModel newsModel=new NewsModel("null");
            newsModel.setId(request.getId());
            newsModel.setTitle(request.getTitle());
            newsModel.setContent(request.getContent());
            newsModel.setAuthorId(request.getAuthorId());
            return newsModel;
        }
    }

    @Component
    public static class MapNewsModelToDtoResponse implements NewsModelMapperToDtoResponse {

        @Override
        public NewsDtoResponse map(NewsModel model){
            NewsDtoResponse newsDtoResponse=new NewsDtoResponse();
            newsDtoResponse.setId(model.getId());
            newsDtoResponse.setContent(model.getContent());
            newsDtoResponse.setTitle(model.getTitle());
            newsDtoResponse.setAuthorId(model.getAuthorId());
            return newsDtoResponse;
        }
    }
}
