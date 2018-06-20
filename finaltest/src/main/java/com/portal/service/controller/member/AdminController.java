package com.portal.service.controller.member;


import com.portal.service.model.member.dto.MemberDTO;
import com.portal.service.service.member.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private final AdminService adminService;

	@Inject
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}

	@RequestMapping("home.do") //세부적인 url mapping
	public String home() {
		return "admin/admin"; //views/admin/login.jsp로 이동
	}

	@RequestMapping("login.do") //세부적인 url mapping
	public String login() {
		return "admin/login"; //views/admin/login.jsp로 이동
	}
	
	@RequestMapping("loginCheck.do")
	public ModelAndView login_check(MemberDTO dto
			, HttpSession session, ModelAndView modelAndView) {
		String name=adminService.loginCheck(dto); //로그인 체크
		if(name != null) { //로그인 성공=>세션변수 저장
			//관리자용 세션변수
			session.setAttribute("admin_id", dto.getId());
			session.setAttribute("admin_userid", dto.getUserid());
			session.setAttribute("admin_name", name);
			//일반 사용자용 세션변수
			session.setAttribute("id", dto.getId());
			session.setAttribute("userid", dto.getUserid());
			session.setAttribute("name", name);
			modelAndView.setViewName("admin/admin"); //admin.jsp로 이동
		}else{ //로그인 실패
			modelAndView.setViewName("admin/login"); //login.jsp로 이동
			modelAndView.addObject("message","error");
		}
		return modelAndView;
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate(); //세션 초기화
		return "redirect:/admin/login.do";
	}
}















