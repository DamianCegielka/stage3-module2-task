package com.mjc.school.service.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.entity.AuthorModel;
import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;
import com.mjc.school.service.mapping.MapAuthorDtoRequestToAuthorModel;
import com.mjc.school.service.mapping.MapAuthorModelToAuthorDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements BaseService<AuthorDtoRequest, AuthorDtoResponse, Long> {

    @Autowired
    BaseRepository<AuthorModel, Long> repository;

    private MapAuthorModelToAuthorDtoResponse mapAuthorModelToAuthorDtoResponse = new MapAuthorModelToAuthorDtoResponse();
    private MapAuthorDtoRequestToAuthorModel mapAuthorDtoRequestToAuthorModel = new MapAuthorDtoRequestToAuthorModel();

    public AuthorService(BaseRepository<AuthorModel, Long> repository) {
        this.repository = repository;
    }

    @Override
    public List<AuthorDtoResponse> readAll() {
        List<AuthorDtoResponse> list = new ArrayList<>();
        repository.readAll().forEach(x -> list.add(mapAuthorModelToAuthorDtoResponse.map(x)));
        return list;
    }

    @Override
    public AuthorDtoResponse readById(Long id) {
        Optional<AuthorModel> authorDtoResponse= repository.readById(id);
        if (authorDtoResponse.isPresent()) {
            return mapAuthorModelToAuthorDtoResponse.map(authorDtoResponse.get());
        }
        return null;
    }

    @Override
    public AuthorDtoResponse create(AuthorDtoRequest createRequest) {
        AuthorModel authorModel = mapAuthorDtoRequestToAuthorModel.map(createRequest);
        return mapAuthorModelToAuthorDtoResponse.map(repository.create(authorModel));
    }

    @Override
    public AuthorDtoResponse update(AuthorDtoRequest updateRequest) {
        AuthorModel authorModel = mapAuthorDtoRequestToAuthorModel.mapUpdate(updateRequest);
        return mapAuthorModelToAuthorDtoResponse.map(repository.update(authorModel));
    }

    @Override
    public boolean deleteById(Long id) {
        return repository.deleteById(id);
    }
}
