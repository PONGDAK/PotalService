package com.portal.service.controller.board;

import com.portal.service.model.board.dto.BoardDTO;
import com.portal.service.service.board.BoardService;
import com.portal.service.service.board.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping("getAttach/{id}")
    @ResponseBody
    public List<String> getAttach(@PathVariable int id){
        return boardService.getAttach(id);
    }


    @RequestMapping("list.do")
    public ModelAndView list(@RequestParam(defaultValue = "1") int currentPage,
                             @RequestParam(defaultValue = "name") String search_option,
                             @RequestParam(defaultValue = "") String keyword) throws Exception{
        int count= boardService.countArticle(search_option, keyword);
        Pager pager = new Pager(count, currentPage);
        int start = pager.getBeginPage();
        List<BoardDTO> list = boardService.listAll(search_option, keyword, start, Pager.PAGE_SCALE);
        HashMap<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("count", count);
        map.put("pager", pager);
        map.put("search_option", search_option);
        map.put("keyword", keyword);
        return new ModelAndView("board/board_list", "map", map);
    }

    @RequestMapping("view.do")
    public ModelAndView view(int id, HttpSession session) throws Exception{
        boardService.increaseViewCount(id, session);
        return new ModelAndView("board/view", "dto", boardService.read(id));
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


    @RequestMapping("update.do")
    public String update(BoardDTO dto) throws Exception{
        if(dto !=null){
            boardService.update(dto);
        }
        System.out.println("dto:"+dto);
        //return "redirect:/board/list.do";
        // 상세 화면으로 되돌아감
        return "redirect:/board/view.do?id="+dto.getId();
    }

    @RequestMapping("delete.do")
    public String delete(int id) throws Exception {
        boardService.delete(id); //삭제 처리
        return "redirect:/board/list.do"; //목록으로 이동
    }
}
