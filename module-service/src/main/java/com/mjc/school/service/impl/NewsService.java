package com.mjc.school.service.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import com.mjc.school.service.mapping.MapNewsDtoRequestToNewsModel;
import com.mjc.school.service.mapping.MapNewsModelToDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NewsService implements BaseService<NewsDtoRequest, NewsDtoResponse, Long> {

    @Autowired
    BaseRepository<NewsModel, Long> repository;

    private MapNewsModelToDtoResponse mapNewsModelToDtoResponse = new MapNewsModelToDtoResponse();
    private MapNewsDtoRequestToNewsModel mapNewsDtoRequestToNewsModel = new MapNewsDtoRequestToNewsModel();


    public NewsService(BaseRepository<NewsModel, Long> repository) {
        this.repository = repository;
    }

    @Override
    public List<NewsDtoResponse> readAll() {
        List<NewsDtoResponse> list = new ArrayList<>();
        repository.readAll().forEach(x -> list.add(mapNewsModelToDtoResponse.map(x)));
        return list;
    }

    @Override
    public NewsDtoResponse readById(Long id) {
        Optional<NewsModel> newsDtoResponse= repository.readById(id);
        if (newsDtoResponse.isPresent()) {
            return mapNewsModelToDtoResponse.map(newsDtoResponse.get());
        }
        return null;
    }

    @Override
    public NewsDtoResponse create(NewsDtoRequest createRequest) {
        NewsModel newsModel = mapNewsDtoRequestToNewsModel.map(createRequest);
        return mapNewsModelToDtoResponse.map(repository.create(newsModel));
    }

    @Override
    public NewsDtoResponse update(NewsDtoRequest updateRequest) {
        NewsModel newsModel = mapNewsDtoRequestToNewsModel.map(updateRequest);
        return mapNewsModelToDtoResponse.map(repository.create(newsModel));
    }

    @Override
    public boolean deleteById(Long id) {
        return repository.deleteById(id);
    }
}
