package com.mjc.school.repository.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.DataSource;
import com.mjc.school.repository.dto.AuthorModelResponse;
import com.mjc.school.repository.entity.AuthorModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepository implements BaseRepository<AuthorModel, Long> {

    private final DataSource dataSource = new DataSource();

    private List<AuthorModel> listAuthor = dataSource.getListAuthor();

    public AuthorRepository() {
        dataSource.loadAuthorsFromDataSource();
    }


    public void loadDataFromDataSource() {
        dataSource.loadNewsFromDataSource();
        dataSource.loadAuthorsFromDataSource();
    }


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
        final AuthorModel[] author = {new AuthorModel()};
        listAuthor.forEach(x -> {
            boolean b = x.getId().equals(id);
            if (b) {
                author[0] = listAuthor.get(Math.toIntExact(id));
            }
        });

        return Optional.of(author[0]);
    }

    @Override
    public AuthorModel create(AuthorModel entity) {
        AuthorModelResponse authorModelResponse = new AuthorModelResponse();
        System.out.println("AUTHOR REPOSITORY" + entity.getId());
        authorModelResponse.map(entity);
        authorModelResponse.print();
        listAuthor.add(entity);
        System.out.println("AUTHOR REPOSITORY" + entity.getId());
        return authorModelResponse.mapToAuthorModel();
    }

    @Override
    public AuthorModel update(AuthorModel entity) {
        listAuthor.get(Math.toIntExact(entity.getId())).setName(entity.getName());
        return entity;
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