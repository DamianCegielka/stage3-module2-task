package com.mjc.school.repository.dto;

import com.mjc.school.repository.entity.AuthorModel;

import java.time.LocalDateTime;

public class AuthorModelResponse {

    private Long id;
    private String name;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateTime;

    public void print() {
        System.out.print("AuthorDtoResponse[");
        System.out.print("id=" + this.getId() + ",");
        System.out.print("title=" + this.getName() + ",");
        System.out.print("createDate=" + this.getCreateDate() + ",");
        System.out.println("lastUpdatedDate=" + this.getLastUpdateTime() + "]");
    }

    public void map(AuthorModel author) {
        this.setId(author.getId());
        this.setName(author.getName());
        this.setCreateDate(author.getCreateDate());
        this.setLastUpdateTime(author.getLastUpdateTime());
    }

    public AuthorModel mapToAuthorModel() {
        AuthorModel authorResult = new AuthorModel("empty model");
        authorResult.setId(this.getId());
        authorResult.setName(this.getName());
        authorResult.setCreateDate(this.getCreateDate());
        authorResult.setLastUpdateTime(this.getLastUpdateTime());
        return authorResult;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
