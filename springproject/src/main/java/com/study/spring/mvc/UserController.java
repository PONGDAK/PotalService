package com.study.spring.mvc;

import com.study.spring.hello.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
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

    @GetMapping("/path/{id}/{name:[a-z]+}")
    //원래는 @PathVariable("id") 이렇게 매핑해줘야하지만 안적어도 알아서 같은이름찾아 매핑해줌
    public ModelAndView user(@PathVariable Integer id, @PathVariable String name, @RequestParam String password, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("user");
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        modelAndView.addObject("user", user);
        //쿠키는 도메인별 패스별 지정되므로 경로를 지정해줘야함 경로지정해주면 이안에서 계속 업데이트만됨
        Cookie idCookie = new Cookie("id", String.valueOf(id));
        Cookie nameCookie = new Cookie("name", name);
        Cookie passwordCookie = new Cookie("password", password);
        idCookie.setPath("/user/cookie");
        nameCookie.setPath("/user/cookie");
        passwordCookie.setPath("/user/cookie");

        //쿠키는 서버사이드에서 리스폰스시 구워짐
        response.addCookie(idCookie);
        response.addCookie(nameCookie);
        response.addCookie(passwordCookie);

        return modelAndView;

    }

    @GetMapping("/cookie")
    public ModelAndView cookie(@CookieValue("id") Integer id, @CookieValue("name") String name, @CookieValue("password") String password){
        ModelAndView modelAndView = new ModelAndView("user");
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        modelAndView.addObject("user", user);
        return modelAndView;

    }
}
