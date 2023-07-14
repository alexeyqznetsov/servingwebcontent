package com.example.servingwebcontent;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        if (user.getLogin().equals("admin") && user.getPassword().equals("password")) {
            user.setLogin(user.getLogin());
            user.setDate(LocalDate.now().toString());
            return user;
        } else {
            throw new IllegalArgumentException("Invalid login or password");
        }
        //user.setLogin(user.getLogin());
        //user.setPassword(user.getPassword());
        //user.setDate(LocalDate.now().toString());
        //return user;
    }
}

