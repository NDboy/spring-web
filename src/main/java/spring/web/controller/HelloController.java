package spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping("/hello")
//@ResponseBody
public class HelloController {


    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        System.out.println("Hello SpringMVC-----------------------------------------------");
        return "Hello SpringMVC";
    }
}
