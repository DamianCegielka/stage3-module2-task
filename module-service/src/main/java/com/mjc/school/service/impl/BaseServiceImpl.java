package com.mjc.school.service.impl;


import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.dto.NewsModelResponse;
import com.mjc.school.repository.entity.News;
import com.mjc.school.repository.impl.AuthorRepositoryImpl;
import com.mjc.school.repository.model.BaseEntity;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.Validator;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoRequestWithIndex;
import com.mjc.school.service.dto.NewsDtoResponse;
import com.mjc.school.service.exception.AuthorIdDoesNotExistException;
import com.mjc.school.service.exception.NewsDoesNotExistException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BaseServiceImpl implements BaseService<NewsDtoRequest, News, Long> {

    private final BaseRepository serviceRepository = new AuthorRepositoryImpl();
    private final Validator serviceValidator = new Validator();


    public void loadAllData() {
       // serviceRepository.loadDataFromDataSource();

    }


    public List<NewsDtoResponse> readAllNews() throws IOException {
        /*
        List<NewsDtoResponse> listResult = new ArrayList<>();
        NewsDtoResponse newsDtoResponse = new NewsDtoResponse();
        serviceRepository.readAllNews().forEach(x ->
                listResult.add(newsDtoResponse.map(x)));
        return listResult;

         */
        return null;
    }


    public NewsDtoResponse readByIdNews(Long index) {
        /*
        NewsDtoResponse newsDtoResponse = new NewsDtoResponse();
        try {
            if (serviceRepository.isNewsOnList(index)) {
                NewsModelResponse newsModelResponse = serviceRepository.readByIdNews(index);
                newsDtoResponse.map(newsModelResponse);
            } else {
                throw new NewsDoesNotExistException(index);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsDtoResponse;

         */
        return null;
    }


    public NewsDtoResponse createNews(NewsDtoRequest newsDtoRequest) {
        /*
        NewsDtoResponse newsDtoResponse = new NewsDtoResponse();
        try {
            serviceValidator.lengthBetween5And30Symbols(newsDtoRequest.getTitle());
            serviceValidator.lengthBetween5And255Symbols(newsDtoRequest.getContent());
            if (!serviceRepository.isAuthorOnList(newsDtoRequest.getAuthorId())) {
                throw new AuthorIdDoesNotExistException(newsDtoRequest.getAuthorId());
            }
            NewsModelResponse newsModelResponse = serviceRepository.createNews(newsDtoRequest.mapToNewsModelRequest());
            newsDtoResponse.map(newsModelResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsDtoResponse;

         */
        return null;
    }


    public NewsDtoResponse updateNews(NewsDtoRequestWithIndex newsDtoRequestWithIndex) {
        /*
        NewsDtoResponse newsDtoResponse = new NewsDtoResponse();
        try {
            if (serviceRepository.isNewsOnList(newsDtoRequestWithIndex.getId())) {
                if (serviceRepository.isAuthorOnList(newsDtoRequestWithIndex.getAuthorId())) {
                    if ((serviceValidator.lengthBetween5And30Symbols(newsDtoRequestWithIndex.getTitle())) &&
                            (serviceValidator.lengthBetween5And255Symbols(newsDtoRequestWithIndex.getContent()))) {
                        NewsModelResponse newsModelResponse = serviceRepository.updateNews(newsDtoRequestWithIndex.mapToNewsModelRequestWithIndex());
                        newsDtoResponse.map(newsModelResponse);
                    }
                } else {
                    throw new AuthorIdDoesNotExistException(newsDtoRequestWithIndex.getAuthorId());
                }
            } else {
                throw new NewsDoesNotExistException(newsDtoRequestWithIndex.getIndex());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsDtoResponse;

         */
        return null;
    }


    public Boolean deleteNews(Long index) {
        /*
        Boolean result = false;
        try {
            if (serviceRepository.isNewsOnList(index)) {
                result = serviceRepository.deleteNews(index);
            } else {
                throw new NewsDoesNotExistException(index);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

         */
        return null;
    }


    @Override
    public List<News> readAll() {
        return serviceRepository.readAll();
    }

    @Override
    public News readById(Long id) {
        return (News) serviceRepository.readById(id).orElse(null);
    }

    @Override
    public News create(NewsDtoRequest createRequest) {
        return new News();
    }

    @Override
    public News update(NewsDtoRequest updateRequest) {
        return new News();
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}