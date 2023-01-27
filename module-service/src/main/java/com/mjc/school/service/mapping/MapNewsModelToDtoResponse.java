package com.mjc.school.service.mapping;


import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.service.dto.NewsDtoResponse;
import org.springframework.stereotype.Component;

@Component
public class MapNewsModelToDtoResponse {

    public NewsDtoResponse map(NewsModel model){
        NewsDtoResponse newsDtoResponse=new NewsDtoResponse();
        newsDtoResponse.setId(model.getId());
        newsDtoResponse.setContent(model.getContent());
        newsDtoResponse.setTitle(model.getTitle());
        newsDtoResponse.setAuthorId(model.getAuthorId());
        return newsDtoResponse;
    }
}
