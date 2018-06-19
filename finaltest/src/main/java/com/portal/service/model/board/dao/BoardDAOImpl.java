package com.portal.service.model.board.dao;

import com.portal.service.model.board.dto.BoardDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        sqlSession.insert("board.addAttach", fullname);
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
    public List<BoardDTO> listAll(int start, int pageSize) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("start", start);
        map.put("pageSize", pageSize);  //2개이상 값전달위해 hashmap 사용
        return sqlSession.selectList("board.listAll", map);
    }

    @Override
    public void increaseViewCount(int id) throws Exception {
        sqlSession.update("board.increaseViewCount", id);
    }

    @Override
    public int countArticle() throws Exception {
        return sqlSession.selectOne("board.countArticle");
    }

    @Override
    public BoardDTO read(int id) throws Exception {
        return sqlSession.selectOne("board.read", id);
    }
}
