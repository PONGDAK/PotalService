package com.study.spring.mvc;

import com.study.spring.hello.Comment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
@Slf4j
public class SpringDataJpaController {
    private final CommentRepository commentRepository;

    @GetMapping
    @Transactional  //트렌잭션 설정할거면 이거 붙여주면됨
    public List<Comment> list(){
        return (List<Comment>) commentRepository.findAll();
    }
}
