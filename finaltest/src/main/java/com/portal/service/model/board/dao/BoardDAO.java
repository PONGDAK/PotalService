package com.portal.service.model.board.dao;

import com.portal.service.model.board.dto.BoardDTO;

import java.util.List;

public interface BoardDAO {
    //첨부파일
    public void deleteFile(String fullname);
    public void addAttach(String fullname);
    public List<String> getAttach(int id);
    public void updateAttach(String fullname, int id);
    //게시판
    public void create(BoardDTO dto) throws Exception;
    public void delete(int id) throws Exception;
    //부가
    public List<BoardDTO> listAll(int start, int pageSize) throws Exception;
    public void increaseViewCount(int id) throws Exception;
    public int countArticle() throws Exception;
}
