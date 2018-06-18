package com.portal.service.controller.board;

import com.portal.service.model.board.dto.BoardDTO;
import com.portal.service.service.board.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
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
    public ModelAndView list() throws Exception{
        List<BoardDTO> list = boardService.listAll();
        HashMap<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("count", list.size());
        System.out.println(map);
        return new ModelAndView("board/list", "map", map);
    }
}
