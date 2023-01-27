package com.mjc.school.repository.dto;

import com.mjc.school.repository.entity.NewsModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class NewsModelResponse {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateTime;
    private Long authorId;

    public void print() {
        System.out.print("NewsDtoResponse[");
        System.out.print("id=" + this.getId() + ",");
        System.out.print("title=" + this.getTitle() + ",");
        System.out.print("content=" + this.getContent() + ",");
        System.out.print("createDate=" + this.getCreateDate() + ",");
        System.out.print("lastUpdatedDate=" + this.getLastUpdateTime() + ",");
        System.out.println("authorId=" + this.getAuthorId() + "]");
    }

    public void map(NewsModel news) {
        this.setId(news.getId());
        this.setTitle(news.getTitle());
        this.setContent(news.getContent());
        this.setCreateDate(news.getCreateDate());
        this.setLastUpdateTime(news.getLastUpdateTime());
        this.setAuthorId(news.getAuthorId());
    }

    public NewsModel mapToNews(){
        NewsModel newsResult=new NewsModel("null");
        newsResult.setId(this.getId());
        newsResult.setTitle(this.getTitle());
        newsResult.setContent(this.getContent());
        newsResult.setCreateDate(this.getCreateDate());
        newsResult.setLastUpdateTime(this.getLastUpdateTime());
        newsResult.setAuthorId(this.getAuthorId());
        return newsResult;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
