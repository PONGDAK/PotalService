package com.study.spring.hello;

import org.springframework.stereotype.Component;

//컴포넌트 붙이면 빈으로 정의
@Component
public class HelloImpl implements Hello{
    @Override
    public String sayHello() {
        return "Hello!!!";
    }
}
