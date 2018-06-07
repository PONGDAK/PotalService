package com.study.spring.mvc;

import com.study.spring.hello.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
        //session
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        session.setAttribute("user",user);

        response.getWriter().println(String.format("<h1> %s : %s </h1><br />", "ID", id));
        response.getWriter().println(String.format("<h1> %s : %s </h1><br />", "Name", name));
        response.getWriter().println(String.format("<h1> %s : %s </h1><br />", "Password", password));
    }

    @GetMapping("/session")
    public ModelAndView session(HttpSession session){
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("user", session.getAttribute("user"));
        return modelAndView;
    }
}
