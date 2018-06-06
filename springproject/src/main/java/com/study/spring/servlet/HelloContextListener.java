package com.study.spring.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@Slf4j
public class HelloContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("---------- Context Listener init -----------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("---------- Context Listener destroy -----------");
    }
}
