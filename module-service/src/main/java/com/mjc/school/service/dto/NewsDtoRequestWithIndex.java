package com.mjc.school.service.dto;

import com.mjc.school.repository.dto.NewsModelResponse;
import com.mjc.school.repository.entity.News;

import java.time.LocalDateTime;

public class NewsDtoRequestWithIndex {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateTime;
    private Long authorId;

    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
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

    public void print() {
        System.out.print("NewsDtoResponse[");
        System.out.print("id=" + this.getId() + ",");
        System.out.print("title=" + this.getTitle() + ",");
        System.out.print("content=" + this.getContent() + ",");
        System.out.print("createDate=" + this.getCreateDate() + ",");
        System.out.print("lastUpdatedDate=" + this.getLastUpdateTime() + ",");
        System.out.println("authorId=" + this.getAuthorId() + "]");
    }

    public void map(NewsModelResponse news) {
        this.setId(news.getId());
        this.setTitle(news.getTitle());
        this.setContent(news.getContent());
        this.setCreateDate(news.getCreateDate());
        this.setLastUpdateTime(news.getLastUpdateTime());
        this.setAuthorId(news.getAuthorId());
    }

    public NewsDtoResponse map(News news) {
        NewsDtoResponse newsDtoResponse=new NewsDtoResponse();
        newsDtoResponse.setId(news.getId());
        newsDtoResponse.setTitle(news.getTitle());
        newsDtoResponse.setContent(news.getContent());
        newsDtoResponse.setCreateDate(news.getCreateDate());
        newsDtoResponse.setLastUpdateTime(news.getLastUpdateTime());
        newsDtoResponse.setAuthorId(news.getAuthorId());
        return newsDtoResponse;
    }

}