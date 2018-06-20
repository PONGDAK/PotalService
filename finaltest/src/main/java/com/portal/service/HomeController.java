package com.portal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Handles requests for the application home page.
 */
@Controller //현재 클래스를 스프링에서 관리하는 컨트롤러로 등록
public class HomeController {

	@RequestMapping(value = "/")
	public String home() {
		return "home";
	}
}





