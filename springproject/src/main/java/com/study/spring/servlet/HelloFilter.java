package com.study.spring.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
public class HelloFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("---------- Filter init -----------");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("---------- Filter start -----------");
        chain.doFilter(request, response);
        log.info("---------- Filter end -----------");
    }

    @Override
    public void destroy() {
        log.info("---------- Filter destroy -----------");
    }
}
