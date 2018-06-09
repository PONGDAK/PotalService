package com.study.spring.hello;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private List<Comment> comments;
}
