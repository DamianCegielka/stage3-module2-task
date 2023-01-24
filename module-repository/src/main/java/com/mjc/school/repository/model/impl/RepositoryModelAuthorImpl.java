package com.mjc.school.repository.model.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.DataSource;
import com.mjc.school.repository.model.entity.Author;
import com.mjc.school.repository.model.entity.News;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositoryModelAuthorImpl implements BaseRepository<Author,Long> {

    private final DataSource dataSource = new DataSource();
    private List<News> listNews = dataSource.getListNews();
    private ArrayList<Author> listAuthor = dataSource.getListAuthor();


    public void loadDataFromDataSource() {
        dataSource.loadNewsFromDataSource();
        dataSource.loadAuthorsFromDataSource();
    }


    @Override
    public List<Author> readAll() {
        return listAuthor;
    }

    @Override
    public Optional<Author> readById(Long id) {
        final Author[] author = {new Author()};
        listAuthor.forEach(x -> {
            boolean b = x.getId().equals(id);
            if (b) {
                author[0] = listAuthor.get(Math.toIntExact(id));
            }
        });

        return Optional.of(author[0]);
    }

    @Override
    public Author create(Author entity) {
        listAuthor.add(entity);
        return entity;
    }

    @Override
    public Author update(Author entity) {
        listAuthor.get(Math.toIntExact(entity.getId())).setName(entity.getName());
        return entity;
    }

    @Override
    public boolean deleteById(Long id) {
        if (listAuthor.removeIf(x -> x.getId().equals(id))) {
            listAuthor.remove(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean existById(Long id) {
        for (Author author : listAuthor) {
            if (author.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}