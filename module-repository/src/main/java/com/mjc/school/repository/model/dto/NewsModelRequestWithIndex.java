package com.mjc.school.repository.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewsModelRequestWithIndex {

    private Long index;
    private String title;
    private String content;
    private Long authorId;

}
