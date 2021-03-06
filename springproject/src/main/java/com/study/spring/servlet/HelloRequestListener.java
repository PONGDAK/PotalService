package com.study.spring.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@Slf4j
@WebListener
public class HelloRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info("---------- Request Listener destroy -----------");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.info("---------- Request Listener init -----------");
    }
}
