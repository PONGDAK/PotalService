package com.study.spring.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//로그인 구현할때 유용하게 사용가능 얘는 구현 메소드가 필수값이아니라서 직접 메소드 오버라이드 해줬음
@Slf4j
public class HelloInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("---------- preHandle -----------");
        //true로 해야 핸들러 까지 감
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("---------- postHandle -----------");
        log.info((String) modelAndView.getModel().get("hello"));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("---------- afterCompletion -----------");
    }
}
