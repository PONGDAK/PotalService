package com.portal.service.controller.board;

import com.portal.service.model.board.dto.ReplyDTO;
import com.portal.service.service.board.ReplyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/reply")
public class ReplyController {
    private final ReplyService replyService;

    @Inject
    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }

    @RequestMapping("insert.do" )
    public void insert(ReplyDTO dto, HttpSession session){
        int id= (int) session.getAttribute("id");
        dto.setId_member(id);
        replyService.create(dto);
    }

    @RequestMapping("list.do")
    public List<ReplyDTO> list_json(int id){
        return replyService.list(id);
    }

}
