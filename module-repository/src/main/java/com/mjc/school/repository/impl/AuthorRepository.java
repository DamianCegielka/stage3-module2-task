package com.mjc.school.repository.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.DataSource;
import com.mjc.school.repository.dto.AuthorModelResponse;
import com.mjc.school.repository.entity.AuthorModel;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepository implements BaseRepository<AuthorModel, Long> {

    private final DataSource dataSource = new DataSource();

    private List<AuthorModel> listAuthor = dataSource.getListAuthor();

    public AuthorRepository() {
        dataSource.loadAuthorsFromDataSource();
    }
/*

    public void loadDataFromDataSource() {
        dataSource.loadNewsFromDataSource();
        dataSource.loadAuthorsFromDataSource();
    }

 */


    @Override
    public List<AuthorModel> readAll() {
        try {
            AuthorModelResponse authorModelResponse = new AuthorModelResponse();
            listAuthor.forEach(x -> {
                authorModelResponse.map(x);
                authorModelResponse.print();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAuthor;
    }

    @Override
    public Optional<AuthorModel> readById(Long id) {
        AuthorModelResponse authorModelResponse = new AuthorModelResponse();
        listAuthor.forEach(x -> {
            boolean b = x.getId().equals(id);
            if (b) authorModelResponse.map(x);
            if (b) authorModelResponse.print();
        });
        return Optional.ofNullable(authorModelResponse.mapToAuthorModel());
    }

    @Override
    public AuthorModel create(AuthorModel entity) {
        AuthorModelResponse authorModelResponse = new AuthorModelResponse();
        authorModelResponse.map(entity);
        authorModelResponse.print();
        listAuthor.add(entity);
        return authorModelResponse.mapToAuthorModel();
    }

    @Override
    public AuthorModel update(AuthorModel entity) {
        AuthorModelResponse authorModelResponse = new AuthorModelResponse();
        listAuthor.forEach(x -> {
            System.out.println("SZUKANE ID " + entity.getId());
            System.out.println("ID: " + x.getId());
            boolean b = x.getId().equals(entity.getId());
            if (b) System.out.println("MAM");
            if (b) x.setName(entity.getName());
            if (b) x.setLastUpdateTime(LocalDateTime.now());
            if (b) authorModelResponse.map(x);
            if (b) authorModelResponse.print();

        });
        return authorModelResponse.mapToAuthorModel();
    }

    @Override
    public boolean deleteById(Long id) {
        if (listAuthor.removeIf(x -> x.getId().equals(id))) {
            System.out.println(true);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean existById(Long id) {
        for (AuthorModel author : listAuthor) {
            if (author.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}