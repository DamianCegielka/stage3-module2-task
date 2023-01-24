package com.mjc.school.repository.model.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.DataSource;
import com.mjc.school.repository.model.dto.NewsModelResponse;
import com.mjc.school.repository.model.entity.Author;
import com.mjc.school.repository.model.entity.News;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositoryModelNewsImpl implements BaseRepository <News,Long> {

    private final DataSource dataSource = new DataSource();
    private List<News> listNews = dataSource.getListNews();
    private ArrayList<Author> listAuthor = dataSource.getListAuthor();


    public void loadDataFromDataSource() {
        dataSource.loadNewsFromDataSource();
        dataSource.loadAuthorsFromDataSource();
    }


    @Override
    public List<News> readAll() {
        try {
            NewsModelResponse newsModelResponse = new NewsModelResponse();
            listNews.forEach(x -> {
                newsModelResponse.map(x);
                newsModelResponse.print();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNews;
    }

    @Override
    public Optional<News> readById(Long id) {
        NewsModelResponse newsModelResponse = new NewsModelResponse();
        listNews.forEach(x -> {
            boolean b = x.getId().equals(id);
            if (b) newsModelResponse.map(x);
            if (b) newsModelResponse.print();
        });
        return Optional.ofNullable(newsModelResponse.mapToNews());
    }

    @Override
    public News create(News entity) {
        NewsModelResponse newsModelResponse = new NewsModelResponse();
        newsModelResponse.map(entity);
        newsModelResponse.print();
        listNews.add(entity);
        return newsModelResponse.mapToNews();
    }

    @Override
    public News update(News entity) {
        NewsModelResponse newsModelResponse = new NewsModelResponse();
        listNews.forEach(x -> {
            boolean b = x.getId().equals(entity.getId());
            if (b) x.setTitle(entity.getTitle());
            if (b) x.setContent(entity.getContent());
            if (b) x.setAuthorId(entity.getAuthorId());
            if (b) x.setLastUpdateTime(LocalDateTime.now());
            if (b) newsModelResponse.map(x);
            if (b) newsModelResponse.print();

        });
        return newsModelResponse.mapToNews();

    }

    @Override
    public boolean deleteById(Long id) {
        if (listNews.removeIf(x -> x.getId().equals(id))) {
            System.out.println(true);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean existById(Long id) {
        for (News news : listNews) {
            if (news.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

}
