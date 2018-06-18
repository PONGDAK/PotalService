package com.portal.service.model.board.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class BoardDTO {
    private int id;
    private String title;
    private String content;
    private String writer;
    private String name;
    private Date post_date;
    private int view_count;
    private int count;
    private String show;
    private String[] files[];
}
