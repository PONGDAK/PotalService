package com.portal.service.service.board;

import com.portal.service.model.board.dao.BoardDAO;
import com.portal.service.model.board.dto.BoardDTO;
import org.springframework.stereotype.Service;

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

    @Override
    public void create(BoardDTO dto) throws Exception {
        boardDAO.create(dto);
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
