package com.mjc.school.repository.model.entity;


import com.mjc.school.repository.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Author implements BaseEntity<Long> {
    private Long id;
    private String name;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }


}
