package com.portal.service.model.board.dao;

import com.portal.service.model.board.dto.ReplyDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
    private final SqlSession sqlSession;

    @Inject
    public ReplyDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
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
        sqlSession.insert("reply.insertReply", dto);
    }
}
