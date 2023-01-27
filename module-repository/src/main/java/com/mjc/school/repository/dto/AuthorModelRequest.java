package com.mjc.school.repository.dto;

public class AuthorModelRequest {

    private Long id;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
