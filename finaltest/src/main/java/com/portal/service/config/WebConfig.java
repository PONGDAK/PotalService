package com.portal.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
@EnableWebMvc  //anntiaion-driven 이랑 같은 효과
@ComponentScan(basePackages = "com.portal.service")
@EnableAspectJAutoProxy //AOP
public class WebConfig implements WebMvcConfigurer{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/admin/login_check.do", "~~").excludePathPatterns("/");
//        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/member/login_check.do");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/include/**").addResourceLocations("/WEB-INF/views/include/");
        registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/views/images/");
        registry.addResourceHandler("/summernote/**").addResourceLocations("/WEB-INF/views/summernote/");

    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.mediaType("js", MediaType.APPLICATION_JSON);
//        configurer.mediaType("x", MediaType.APPLICATION_XML);
    }

    //뷰리졸버 달아줌
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
        registry.enableContentNegotiation(new MappingJackson2JsonView());
//        registry.enableContentNegotiation(new MappingJackson2XmlView());
    }

    //멀티파트 뷰 리졸버 달아줌 ... <beans:bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver"/>
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxInMemorySize(100000000);
        multipartResolver.setMaxUploadSize(200000000);
        return new CommonsMultipartResolver();
    }

    @Bean
    public String uploadPath(){
        return "d:/upload";
    }
}
