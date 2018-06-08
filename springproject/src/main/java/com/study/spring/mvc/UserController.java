package com.study.spring.mvc;

import com.study.spring.hello.User;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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

    //user 패스이름으로 user.jsp찾음
    @GetMapping
    public User user(){
        return new User();
    }

    //GetMapping으로하면 위의 메소드랑 구분이 안되서 뻑남
    @PostMapping
    public void user(User user){
        log.info("------ void test user ------");
    }

    @GetMapping("/string")
    public String returnStringTest(){
        return "user";
    }

    //특정 주소로 보내주는것 redirect
    @GetMapping("/redirect")
    public String redirectStringTest(){
        return "redirect:/user";
    }

    //forward는 주소창을 유지하고 해당되는 뷰를 보여주는것 리퀘스트의 컨텐츠정보를 잘들고 넘겨줌
    @GetMapping("/forward")
    public String forwardStringTest(){
        return "forward:/user";
    }

    /*
      //파라미터로 들어온 애들 다 알아서 잘 감싸서 전달해줌 왠만한 역할 다해줌 거기다 @ModelAttribute생략해서 써도됨
    @GetMapping
    public void user(@ModelAttribute User user){
    }

    위와 같은 코드
    @GetMapping
    public void user( User user){
    }

    오브젝트 네임을 그대로 본따서 찾음 modelAndView.addObject("user", user); 역할
    @GetMapping
    public User user(){
        return User();
    }
    */

    /*별도로 명시안하고 void면 user.jsp를 찾음
      Model 오브젝트 다루기 편함 Map 마샬링 편함  ModelMap 둘다 다루기 편함
    @GetMapping
    public void user(Model model){
        User user = new User();
        user.setId(1);
        user.setName("test");
        user.setPassword("1234");
        model.addAttribute(user);
    }
     String으로도 구현가능 위와 같은 동작
    @GetMapping
    public String user(Model model){
        User user = new User();
        user.setId(1);
        user.setName("test");
        user.setPassword("1234");
        model.addAttribute(user);
        return "user";
    }
    */
}
