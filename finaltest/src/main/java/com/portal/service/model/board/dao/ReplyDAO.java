package com.portal.service.model.board.dao;

import com.portal.service.model.board.dto.ReplyDTO;

import java.util.List;

public interface ReplyDAO {
    public List<ReplyDTO> list(int id);
    public int count(int id);
    public void create(ReplyDTO dto);
}
