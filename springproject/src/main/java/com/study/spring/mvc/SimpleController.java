package com.study.spring.mvc;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@component를 상속받은애임 컨트롤러로 지정되면 빈으로 지정되고 컨트롤러 역할을함  service , repository또한 그럼
@org.springframework.stereotype.Controller("/helloworld")
@RequestMapping("/helloworld")
public class SimpleController {

    //annotaion 기반 handl er adaptor
    @RequestMapping("/hi")
    public ModelAndView hello() {
//        ModelAndView modelAndView = new ModelAndView("hello");
        ModelAndView modelAndView = null;
        modelAndView.addObject("hello", "Hello World!!!");
        return modelAndView;
    }

    @ExceptionHandler(NullPointerException.class)
    public String error(NullPointerException e){
        return "error";
    }
}
