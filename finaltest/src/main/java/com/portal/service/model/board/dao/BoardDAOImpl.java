package com.portal.service.model.board.dao;

import com.portal.service.model.board.dto.BoardDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class BoardDAOImpl implements BoardDAO {

    private final SqlSession sqlSession;

    @Inject
    public BoardDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void deleteFile(String fullname) {

    }

    @Override
    public void addAttach(String fullname) {

    }

    @Override
    public List<String> getAttach(int id) {
        return null;
    }

    @Override
    public void updateAttach(String fullname, int id) {

    }

    @Override
    public void create(BoardDTO dto) throws Exception {
        sqlSession.insert("board.insert", dto);
    }

    @Override
    public void delete(int id) throws Exception {

    }

    @Override
    public List<BoardDTO> listAll() throws Exception {
        return sqlSession.selectList("board.listAll");
    }

    @Override
    public void increaseViewCount(int id) throws Exception {

    }

    @Override
    public int countArticle() throws Exception {
        return 0;
    }
}
