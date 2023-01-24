package com.mjc.school.repository.model.entity;

import com.mjc.school.repository.model.dto.NewsModelRequest;
import com.mjc.school.repository.model.BaseEntity;
import com.mjc.school.repository.model.dto.NewsModelResponse;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
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



}
