package com.portal.service.controller.member;

import com.portal.service.model.member.dto.MemberDTO;
import com.portal.service.service.member.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String signin(){
        return "member/write";
    }

    @RequestMapping("insert.do")
    public ModelAndView insert(MemberDTO dto) {
        memberService.insertMember(dto);
        return new ModelAndView("member/login", "text", "정상적으로 가입되었습니다.");
    }

}









