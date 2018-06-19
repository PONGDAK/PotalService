package com.portal.service.service.board;

import com.portal.service.model.board.dto.BoardDTO;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface BoardService {
    //첨부파일
    public void deleteFile(String fullName);
    public List<String> getAttach(int id);
    //게시판
    public void create(BoardDTO dto) throws Exception;
    public BoardDTO read(int id) throws Exception;
    public void update(BoardDTO dto) throws Exception;
    public void delete(int id) throws Exception;
    //부가
    public List<BoardDTO> listAll(int start, int pageSize) throws Exception;
    public void increaseViewCount(int id, HttpSession session) throws Exception;
    public int countArticle() throws Exception;
}
