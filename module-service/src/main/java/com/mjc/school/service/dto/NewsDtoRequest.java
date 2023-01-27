package com.mjc.school.service.dto;

import com.mjc.school.repository.dto.NewsModelRequest;

public class NewsDtoRequest {

    Long id;
    String title;
    String content;
    Long authorId;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
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

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public NewsModelRequest mapToNewsModelRequest() {
        NewsModelRequest newsModelRequest = new NewsModelRequest();
        newsModelRequest.setId(this.getId());
        newsModelRequest.setTitle(this.getTitle());
        newsModelRequest.setContent(this.getContent());
        newsModelRequest.setAuthorId(this.getAuthorId());
        return newsModelRequest;
    }
}