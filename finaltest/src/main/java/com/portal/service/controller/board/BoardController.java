package com.portal.service.controller.board;

import com.portal.service.model.board.dto.BoardDTO;
import com.portal.service.service.board.BoardService;
import com.portal.service.service.board.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @Inject
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping("list.do")
    public ModelAndView list(@RequestParam(defaultValue = "1") int currentPage) throws Exception{
        int count= boardService.countArticle();
        Pager pager = new Pager(count, currentPage);
        int start = pager.getBeginPage();
        List<BoardDTO> list = boardService.listAll(start, Pager.PAGE_SCALE);
        HashMap<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("count", list.size());
        map.put("pager", pager);
        System.out.println(pager.getCurrentBlock() + ":" + pager.getNextBlock());
        return new ModelAndView("board/board_list", "map", map);
    }

    @RequestMapping("write.do")
    public String write(){
        return "board/write";
    }

    @RequestMapping("insert.do")
    public String insert(BoardDTO dto, HttpSession session) throws Exception {
        System.out.println(session);
        int id_member = (int) session.getAttribute("id");
        dto.setId_member(id_member);
        boardService.create(dto);
        return "redirect:/board/list.do";
    }
}
