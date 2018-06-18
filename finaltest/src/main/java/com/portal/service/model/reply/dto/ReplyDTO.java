package com.portal.service.model.reply.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReplyDTO {
    private int id;
    private int id_board;
    private String replytext;
    private String replyer;
    private String name;
    private Date post_date;
    private Date update_date;
    private String secret_reply;
    private String writer;
}
