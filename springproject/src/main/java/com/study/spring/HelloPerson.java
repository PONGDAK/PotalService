package com.study.spring;

import lombok.Data;

@Data
public class HelloPerson implements Hello {
    private String name;
    private Hello hello;

    @Override
    public String sayHello() {
        return hello.sayHello() + " " + name;
    }
}
