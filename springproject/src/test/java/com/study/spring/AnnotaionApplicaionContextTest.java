package com.study.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AnnotaionApplicaionContextTest {

    @Test
    public void annotationApplicationContextTest(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.study.spring");
        Hello hello = applicationContext.getBean("helloPerson", Hello.class);
        assertThat(hello.sayHello(), is("Hello!!! 테스터"));
    }
}
