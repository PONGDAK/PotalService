package com.study.spring.servlet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Slf4j
//Controller 추가로 서브렛 빈으로 만듬
@Controller("/hello")
public class HelloServlet extends GenericServlet{
    @Override
    public void destroy() {
        log.info("---------- servlet destroy -----------");
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        log.info("---------- servlet init -----------");
        super.init();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        log.info("---------- servlet service -----------");
        //옛날에는 이렇게 코드로 다 보내줌
        res.getWriter().println("<h1> Hello World !!!</h1>");
    }
}
