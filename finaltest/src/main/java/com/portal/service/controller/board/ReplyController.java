package com.portal.service.controller.board;

import com.portal.service.model.board.dto.ReplyDTO;
import com.portal.service.service.board.ReplyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/reply")
public class ReplyController {
    private final ReplyService replyService;

    @Inject
    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }

    @RequestMapping("insert.do")
    public void insert(ReplyDTO dto, HttpSession session){
        String userid= (String) session.getAttribute("userid");
        dto.setReplyer(userid);
        replyService.create(dto);
    }
}
