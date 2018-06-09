package com.study.spring.hello;

// is 사용하려고
import static org.hamcrest.CoreMatchers.*;
// asssertThat 사용하려고
import static org.hamcrest.MatcherAssert.*;

import com.study.spring.hello.Hello;
import com.study.spring.hello.HelloImpl;
import com.study.spring.hello.HelloPerson;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.StaticApplicationContext;

public class StaticApplicationContextTest {
    //테스트 케이스를 작성하다보면 아주가끔 필요함
    //코드로 직접 빈 등록해서 관리함
    @Test
    public void staticApplicationContextTest(){
        StaticApplicationContext applicationContext = new StaticApplicationContext();
        applicationContext.registerSingleton("hello", HelloImpl.class);
        Hello hello = applicationContext.getBean("hello", Hello.class);
        assertThat(hello.sayHello(), is("Hello!!!"));
    }

     //특정빈만 빠르게 테스트하거나 생명주기같은거 확인하고 싶을때 종종 사용함
    @Test
    public void staticApplicationContextWithDI(){
        StaticApplicationContext applicationContext = new StaticApplicationContext();
        applicationContext.registerSingleton("hello", HelloImpl.class);
        BeanDefinition beanDefinition = new RootBeanDefinition(HelloPerson.class);
        beanDefinition.getPropertyValues().addPropertyValue("name", "테스터");

        //Contsructor Injection을 static으로 하는 방법
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(new RuntimeBeanReference("hello"));

//        beanDefinition.getPropertyValues().addPropertyValue("hello", new RuntimeBeanReference("hello"));
        applicationContext.registerBeanDefinition("helloPerson", beanDefinition);
        Hello hello = applicationContext.getBean("helloPerson", Hello.class);
        assertThat(hello.sayHello(), is("Hello!!! 테스터"));
    }
}
