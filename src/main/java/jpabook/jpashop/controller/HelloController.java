package jpabook.jpashop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    //getMapping 은 주소창
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!!!");
        // return 은 화면 이름
        return "hello";
    }
}
