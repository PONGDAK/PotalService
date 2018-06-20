package com.portal.service.service.board;

import com.portal.service.model.board.dao.BoardDAO;
import com.portal.service.model.board.dto.BoardDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardDAO boardDAO;

    @Inject
    public BoardServiceImpl(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    @Override
    public void deleteFile(String fullName) {
        boardDAO.deleteFile(fullName);
    }

    @Override
    public List<String> getAttach(int id) {
        return boardDAO.getAttach(id);
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
        return boardDAO.read(id);
    }

    @Transactional
    @Override
    public void update(BoardDTO dto) throws Exception {
        boardDAO.update(dto);
        String[] files =dto.getFiles();
        if(files==null) return;
        for(String name : files){
            boardDAO.updateAttach(name, dto.getId());
        }
    }

    @Transactional
    @Override
    public void delete(int id) throws Exception {
        boardDAO.delete(id);
    }

    @Override
    public List<BoardDTO> listAll(int start, int pageSize) throws Exception {
        return boardDAO.listAll(start, pageSize);
    }

    @Override
    public void increaseViewCount(int id, HttpSession session) throws Exception {
        //조회수 갱신제한 (나중에 쿠키나 세션에 변수 추가해서 하는식으로 하는게 좋을듯함)
        long update_time=0;
        if(session.getAttribute("update_time_" + id) != null){
            update_time = (long) session.getAttribute("update_time_" + id);
        }
        long current_time=System.currentTimeMillis();
        if(current_time - update_time > 24*60*60*1000) { //하루에에 한번 조회수 갱신가능
            boardDAO.increaseViewCount(id);
            session.setAttribute("update_time_"+id, current_time);
        }
    }

    @Override
    public int countArticle() throws Exception {
        return boardDAO.countArticle();
    }
}
