import com.study.spring.Hello
import com.study.spring.HelloImpl
import com.study.spring.HelloPerson

beans {
    hello(HelloImpl) {
    }
//    그루비에서 constructor injection
    helloPerson(HelloPerson, name) {
        name = '테스터'
    }
}