package com.portal.service.controller.member;

import com.portal.service.model.member.dto.MemberDTO;
import com.portal.service.service.member.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@Controller //컨트롤러 빈으로 등록
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @Inject
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping("login.do")
    public String login() {
        return "member/login";
    }

    @RequestMapping("loginCheck.do")
    public ModelAndView login_check(MemberDTO dto, HttpSession session) {
        boolean result = memberService.loginCheck(dto, session);
        ModelAndView modelAndView = new ModelAndView();
        if (result) {
            modelAndView.setViewName("home");
        } else {
            modelAndView.setViewName("member/login");
            modelAndView.addObject("message", "error");
        }
        return modelAndView;
    }

    @RequestMapping("logout.do")
    public ModelAndView logout(HttpSession session) {
        memberService.logout(session); //세션 초기화
        return new ModelAndView("member/login", "message", "logout");
    }

    @RequestMapping("signin.do")
    public String signin() {
        return "member/write";
    }

    @RequestMapping("insert.do")
    public ModelAndView insert(MemberDTO dto) {
        memberService.insertMember(dto);
        return new ModelAndView("member/login", "text", "정상적으로 가입되었습니다.");
    }

    @RequestMapping("update.do")
    public String update(MemberDTO dto, HttpSession session, Model model) {
        dto.setId((Integer) session.getAttribute("id"));
        dto.setUserid((String) session.getAttribute("userid"));
        boolean result = memberService.checkPw(dto.getId(), dto.getPasswd());
        if (result) {
            memberService.updateMember(dto);
            memberService.loginCheck(dto, session);
            return "redirect:/";
        } else {
            System.out.print(dto);
            model.addAttribute("dto", dto);
            model.addAttribute("join_date", memberService.viewMember(dto.getUserid()).getJoin_date());
            model.addAttribute("message", "비밀번호를 확인하세요.");
            return "member/view";
        }
    }

    @RequestMapping("delete.do")
    public String delete(int id) {
        memberService.deleteMember(id);
        return "redirect:/member/view.do";
    }

    @RequestMapping("cancel.do")
    public String cancel(int id) {
        memberService.cancelMember(id);
        return "redirect:/member/view.do";
    }

    @RequestMapping("view.do")
    public String view(HttpSession httpSession, Model model) {
        model.addAttribute("dto", memberService.viewMember((String) httpSession.getAttribute("userid")));
        return "member/view";
    }

}









