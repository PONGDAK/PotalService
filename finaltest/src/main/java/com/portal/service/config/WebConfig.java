package com.portal.service.config;

import com.portal.service.interceptor.AdminInterceptor;
import com.portal.service.interceptor.LoginInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc  //anntiaion-driven 이랑 같은 효과
@ComponentScan(basePackages = "com.portal.service")
@MapperScan("com.portal.service.model.memo")
@EnableAspectJAutoProxy //AOP
@EnableTransactionManagement
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
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring?characterEncoding=utf-8");
        dataSource.setUsername("spring");
        dataSource.setPassword("1234");
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource());
//        sqlSessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappers/**/*Mapper.xml"));

        return sqlSessionFactory;
    }

    @Bean(destroyMethod = "clearCache")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public String uploadPath(){
        return "d:/upload";
    }
}
