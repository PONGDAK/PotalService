package com.study.spring.mvc;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@component를 상속받은애임 컨트롤러로 지정되면 빈으로 지정되고 컨트롤러 역할을함  service , repository또한 그럼
@org.springframework.stereotype.Controller("/helloworld")
public class SimpleController implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("hello", "Hello World!!!");
        return modelAndView;
    }
}
