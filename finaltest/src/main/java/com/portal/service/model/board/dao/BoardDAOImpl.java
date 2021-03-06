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
    public void deleteFile(String fullName) {
        sqlSession.delete("board.deleteFile", fullName);
    }

    @Override
    public void addAttach(String fullName) {
        sqlSession.insert("board.addAttach", fullName);
    }

    @Override
    public List<String> getAttach(int id) {
        return sqlSession.selectList("board.getAttach", id);
    }

    @Override
    public void updateAttach(String fullName, int id) {
        Map<String, Object> map = new HashMap<>();
        map.put("fullName", fullName);
        map.put("id", id);
        sqlSession.insert("board.updateAttach", map);
    }

    @Override
    public void update(BoardDTO dto) throws Exception {
        sqlSession.update("board.update", dto);
    }

    @Override
    public void create(BoardDTO dto) throws Exception {
        sqlSession.insert("board.insert", dto);
    }

    @Override
    public void delete(int id) throws Exception {
        sqlSession.delete("board.delete", id);
    }

    @Override
    public List<BoardDTO> listAll(String search_option, String keyword, int start, int pageSize) throws Exception {
        Map<String, Object> map = new HashMap<>();
        System.out.println(search_option +"  " + keyword);
        map.put("search_option", search_option);
        map.put("keyword", "%"+ keyword + "%");
        map.put("start", start);
        map.put("pageSize", pageSize);  //2개이상 값전달위해 hashmap 사용
        return sqlSession.selectList("board.listAll", map);
    }

    @Override
    public void increaseViewCount(int id) throws Exception {
        sqlSession.update("board.increaseViewCount", id);
    }

    @Override
    public int countArticle(String search_option, String keyword) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("search_option", search_option);
        map.put("keyword", "%"+ keyword + "%");
        return sqlSession.selectOne("board.countArticle", map);
    }

    @Override
    public BoardDTO read(int id) throws Exception {
        return sqlSession.selectOne("board.read", id);
    }
}
