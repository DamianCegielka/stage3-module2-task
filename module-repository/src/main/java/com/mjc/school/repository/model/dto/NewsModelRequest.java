package com.mjc.school.repository.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewsModelRequest {
    String title;
    String content;
    Long authorId;

}
