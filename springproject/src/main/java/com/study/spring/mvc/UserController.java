package com.study.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RequestMapping("/user")
@Controller
public class UserController {
    //response 객체에 직접 리턴값 실으려고 return 안씀
    @GetMapping("/servlet")
    public void servlet(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        response.getWriter().println(String.format("<h1> %s : %s </h1><br />", "ID", id));
        response.getWriter().println(String.format("<h1> %s : %s </h1><br />", "Name", name));
        response.getWriter().println(String.format("<h1> %s : %s </h1><br />", "Password", password));

    }
}
