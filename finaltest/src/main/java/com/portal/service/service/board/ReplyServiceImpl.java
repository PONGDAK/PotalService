package com.portal.service.service.board;

import com.portal.service.model.board.dao.ReplyDAO;
import com.portal.service.model.board.dto.ReplyDTO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService{
    private final ReplyDAO replyDAO;

    @Inject
    public ReplyServiceImpl(ReplyDAO replyDAO) {
        this.replyDAO = replyDAO;
    }

    @Override
    public List<ReplyDTO> list(int id) {
        return null;
    }

    @Override
    public int count(int id) {
        return 0;
    }

    @Override
    public void create(ReplyDTO dto) {
        replyDAO.create(dto);
    }
}
