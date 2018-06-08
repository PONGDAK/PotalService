package com.study.spring.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MappingJackson2XmlView;
import org.springframework.web.util.UrlPathHelper;

@Configuration
@EnableWebMvc  //anntiaion-driven 이랑 같은 효과
@ComponentScan(basePackages = "com.study.spring")
public class WebConfig implements WebMvcConfigurer{
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        if(configurer.getUrlPathHelper() == null) {
            configurer.setUrlPathHelper(new UrlPathHelper());
        }
        configurer.getUrlPathHelper().setRemoveSemicolonContent(false);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HelloInterceptor());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/static/");
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.mediaType("js", MediaType.APPLICATION_JSON);
        configurer.mediaType("x", MediaType.APPLICATION_XML);
    }

    //뷰리졸버 달아줌
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
        registry.enableContentNegotiation(new MappingJackson2JsonView());
        registry.enableContentNegotiation(new MappingJackson2XmlView());
    }

    //멀티파트 뷰 리졸버 달아줌 ... <beans:bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver"/>
    @Bean
    public MultipartResolver multipartResolver() {
        return new CommonsMultipartResolver();
    }
}
