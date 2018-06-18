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

    @RequestMapping("address.do")
    public String address() {
        return "member/join";
    }

    @RequestMapping("login.do") //세부적인 url 매핑
    public String login() {
        return "member/login";
    }

    @RequestMapping("login_check.do")
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

}









