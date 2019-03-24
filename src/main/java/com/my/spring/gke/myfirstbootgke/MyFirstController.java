package com.my.spring.gke.myfirstbootgke;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstController {

   @RequestMapping("/greet")
    public String greet() {
        return "Greetings from Spring Boot!";
    }
}


