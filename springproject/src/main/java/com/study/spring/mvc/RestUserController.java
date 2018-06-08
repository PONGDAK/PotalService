package com.study.spring.mvc;

import com.study.spring.hello.User;
import org.springframework.web.bind.annotation.*;

//RestController 로 쓰면 모든 메소드에 @ResponseBody가 있는것으로 동작함
@RestController
@RequestMapping("/rest")
public class RestUserController {
    @GetMapping("{id}")
    public User get(@PathVariable Integer id) {
        User user = new User();
        user.setId(id);
        user.setName("Tester");
        user.setPassword("1111");
        return user;
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return user;
    }

    @PutMapping
    public User update(@RequestBody User user) {
        return user;
    }

    @DeleteMapping
    public void delete(@PathVariable Integer id) {

    }
}
