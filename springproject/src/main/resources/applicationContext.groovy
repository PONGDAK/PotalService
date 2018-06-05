import com.study.spring.Hello
import com.study.spring.HelloImpl
import com.study.spring.HelloPerson

beans {
    hello(HelloImpl) {
    }
    helloPerson(HelloPerson) {
        name = '테스터'
        hello = hello
    }
}