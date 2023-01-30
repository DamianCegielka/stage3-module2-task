package com.mjc.school.repository.entity;

import com.mjc.school.repository.dto.AuthorModelRequest;
import com.mjc.school.repository.model.BaseEntity;

import java.time.LocalDateTime;

public class AuthorModel implements BaseEntity<Long> {

    private static Long idGenerator = 0L;
    private Long id;
    private String name;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateTime;

    public AuthorModel(AuthorModelRequest authorModelRequest) {
        idGenerator++;
        this.setId(AuthorModel.idGenerator);
        this.setName(authorModelRequest.getName());
        this.setCreateDate(LocalDateTime.now());
        this.setLastUpdateTime(LocalDateTime.now());
    }

    public AuthorModel() {
        idGenerator++;
        this.setId(AuthorModel.idGenerator);
        this.setCreateDate(LocalDateTime.now());
        this.setLastUpdateTime(LocalDateTime.now());
    }

    public AuthorModel(String empty) {
        this.setId(AuthorModel.idGenerator);
        this.setCreateDate(LocalDateTime.now());
        this.setLastUpdateTime(LocalDateTime.now());
    }


    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        if (id != null) {
            this.id = id;
        } else
            this.id = AuthorModel.idGenerator;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
