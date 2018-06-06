import com.study.spring.hello.HelloImpl
import com.study.spring.hello.HelloPerson

beans {
    hello(HelloImpl) {
    }
//    그루비에서 constructor injection
    helloPerson(HelloPerson, name) {
        name = '테스터'
    }
}