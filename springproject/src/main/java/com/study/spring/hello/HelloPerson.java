package com.study.spring.hello;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
//lombok에서 final 붙은애들 constructor 생성하고 Autowired 해줌
@RequiredArgsConstructor
//얘는 전부 constructor 생성하고 Autowired 해줌
//@AllArgsConstructor
public class HelloPerson implements Hello {
    @Value("테스터")
    private String name;
    //Autowired로 의존성주입 한번에 같은폴더내에 이름으로 찾음 만약 같은게 두개있으면 qualifier로 이름지정가능
    //setter를 통해 의존성주입함 근데신기하게 Autowired는 setter 없어도됨
//1.    @Autowired
    private final Hello hello;

    //Contructor 인젝션을 많이사용함 실수로 인젝션 되야할부분에 안붙이게되면 에러나는데
    //이렇게 생성자를통한 의존성주입은 그러한 실수를 예방해줌
//2.    @Autowired
//    public HelloPerson(Hello hello){
//        this.hello = hello;
//    }

    @Override
    public String sayHello() {
        return hello.sayHello() + " " + name;
    }
}
