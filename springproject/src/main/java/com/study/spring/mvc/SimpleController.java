package com.study.spring.mvc;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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

    @RequestMapping(path = "/upload", method = RequestMethod.GET)
    public String upload(){
        return "upload";
    }

    //HttpServletRequest 는 필요없는데 저장된경로 알아보려고 추가
    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public ModelAndView upload(@RequestParam("file")MultipartFile file, HttpServletRequest request) throws IOException {
        //apache commons 오픈소스 이용 파일업로드 (기본적으로 스프링이 채택하기도 했음)
        File path = new File(request.getServletContext().getRealPath("/") + "/WEB-INF/static/" + file.getOriginalFilename());
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write(file.getBytes());
        bufferedOutputStream.close();
        ModelAndView modelAndView = new ModelAndView("upload");
        modelAndView.addObject("url", "/images/" + file.getOriginalFilename()) ;
        return modelAndView;
    }
}
