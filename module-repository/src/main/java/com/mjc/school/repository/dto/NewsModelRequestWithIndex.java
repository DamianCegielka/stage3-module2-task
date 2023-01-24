package com.mjc.school.repository.dto;

import lombok.Getter;
import lombok.Setter;


public class NewsModelRequestWithIndex {

    private Long index;
    private String title;
    private String content;
    private Long authorId;

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
