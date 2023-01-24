package com.mjc.school.repository.entity;

import com.mjc.school.repository.dto.NewsModelRequest;
import com.mjc.school.repository.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


public class News implements BaseEntity<Long> {

    private static Long idGenerator = 0L;
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateTime;
    private Long authorId;
    @Override
    public Long getId() {
        return id;
    }
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public News(NewsModelRequest newsDTOCreation) {
        idGenerator++;
        this.setId(News.idGenerator);
        this.setTitle(newsDTOCreation.getTitle());
        this.setCreateDate(LocalDateTime.now());
        this.setLastUpdateTime(LocalDateTime.now());
        this.setContent(newsDTOCreation.getContent());
        this.setAuthorId(newsDTOCreation.getAuthorId());
    }

    public News() {
        idGenerator++;
        setId(News.idGenerator);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public Long getAuthorId() {
        return authorId;
    }
}
