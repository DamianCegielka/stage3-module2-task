package com.mjc.school.repository.model.dto;

import com.mjc.school.repository.model.entity.News;
import com.mjc.school.repository.model.BaseEntity;
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

    public void map(News news) {
        this.setId(news.getId());
        this.setTitle(news.getTitle());
        this.setContent(news.getContent());
        this.setCreateDate(news.getCreateDate());
        this.setLastUpdateTime(news.getLastUpdateTime());
        this.setAuthorId(news.getAuthorId());
    }

    public News mapToNews(){
        News newsResult=new News();
        newsResult.setId(this.getId());
        newsResult.setTitle(this.getTitle());
        newsResult.setContent(this.getContent());
        newsResult.setCreateDate(this.getCreateDate());
        newsResult.setLastUpdateTime(this.getLastUpdateTime());
        newsResult.setAuthorId(this.getAuthorId());
        return newsResult;
    }


}
