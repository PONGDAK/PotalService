package com.portal.service.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MemberDTO {
    private Integer id;
    private String userid;
    private String passwd;
    private String name;
    private String email;
    private Date date;

}
