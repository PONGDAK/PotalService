package com.study.spring.hello;

import lombok.Data;

@Data
public class Comment {
    private Integer id;
    private User user;
    private String content;
}
