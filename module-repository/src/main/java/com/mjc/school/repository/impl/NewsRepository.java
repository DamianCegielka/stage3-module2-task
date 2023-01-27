package com.mjc.school.repository.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.DataSource;
import com.mjc.school.repository.dto.NewsModelResponse;
import com.mjc.school.repository.entity.NewsModel;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class NewsRepository implements BaseRepository<NewsModel, Long> {


    private final DataSource dataSource = new DataSource();

    public NewsRepository() {
        dataSource.loadNewsFromDataSource();
    }

    private List<NewsModel> listNews = dataSource.getListNews();
    ;


    public void loadDataFromDataSource() {
        dataSource.loadNewsFromDataSource();
        dataSource.loadAuthorsFromDataSource();
    }


    @Override
    public List<NewsModel> readAll() {
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
    public Optional<NewsModel> readById(Long id) {
        NewsModelResponse newsModelResponse = new NewsModelResponse();
        listNews.forEach(x -> {
            boolean b = x.getId().equals(id);
            if (b) newsModelResponse.map(x);
            if (b) newsModelResponse.print();
        });
        return Optional.ofNullable(newsModelResponse.mapToNews());
    }

    @Override
    public NewsModel create(NewsModel entity) {
        NewsModelResponse newsModelResponse = new NewsModelResponse();
        newsModelResponse.map(entity);
        newsModelResponse.print();
        listNews.add(entity);
        return newsModelResponse.mapToNews();
    }

    @Override
    public NewsModel update(NewsModel entity) {
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
        for (NewsModel news : listNews) {
            if (news.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

}
