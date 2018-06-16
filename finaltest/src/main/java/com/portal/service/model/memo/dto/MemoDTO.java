package com.portal.service.model.memo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@NoArgsConstructor
@Data
public class MemoDTO {
    private int id;
    @NonNull
    private String writer;
    @NonNull
    private  String memo;
    private Date post_date;
}
