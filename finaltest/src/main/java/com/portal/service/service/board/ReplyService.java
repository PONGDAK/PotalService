package com.portal.service.service.board;

import com.portal.service.model.board.dto.ReplyDTO;

import java.util.List;

public interface ReplyService {
    public List<ReplyDTO> list(int id);
    public int count(int id);
    public void create(ReplyDTO dto);
}
