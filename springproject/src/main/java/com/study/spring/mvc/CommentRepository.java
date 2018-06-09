package com.study.spring.mvc;

import com.study.spring.hello.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
}
