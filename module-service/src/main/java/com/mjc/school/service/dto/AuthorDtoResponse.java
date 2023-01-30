package com.mjc.school.service.dto;

import java.time.LocalDateTime;

public class AuthorDtoResponse {

    private Long id;
    private String name;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateTime;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }


    public void print() {
        System.out.print("AuthorDtoResponse[");
        System.out.print("id=" + this.getId() + ",");
        System.out.print("title=" + this.getName() + ",");
        System.out.print("createDate=" + this.getCreateDate() + ",");
        System.out.print("lastUpdatedDate=" + this.getLastUpdateTime() + ",");
    }
}
