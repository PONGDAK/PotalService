package com.portal.service.service.board;

import com.portal.service.model.board.dao.BoardDAO;
import com.portal.service.model.board.dto.BoardDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardDAO boardDAO;

    @Inject
    public BoardServiceImpl(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    @Override
    public void deleteFile(String fullname) {

    }

    @Override
    public List<String> getAttach(int id) {
        return null;
    }

    @Transactional  //글쓰기랑 첨부파일추가는 하나의 동작이되야함 (게시물번호 같음)
    @Override
    public void create(BoardDTO dto) throws Exception {
        boardDAO.create(dto);
        String[] files = dto.getFiles();
        if(files==null) return;
        for(String name : files){
            boardDAO.addAttach(name);
        }
    }

    @Override
    public BoardDTO read(int id) throws Exception {
        return null;
    }

    @Override
    public void update(BoardDTO dto) throws Exception {

    }

    @Override
    public void delete(int id) throws Exception {

    }

    @Override
    public List<BoardDTO> listAll() throws Exception {
        return boardDAO.listAll();
    }

    @Override
    public void increaseViewCount(int id) throws Exception {

    }

    @Override
    public int countArticle() throws Exception {
        return 0;
    }
}
