package Hello.HelloSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class helloController {

    //Model/View Controller
    @GetMapping("hello")
    public String hello(Model model){
        //controller가 자동으로 값을 매핑해서 넣어주고 thymleaf에 전달
        model.addAttribute("data", "hello!");
        return "hello";
        //view page인 hello.html을 찾아서 반환해줌.
        //viewResolver에 의해 템플릿을 찾아가게 된다.
    }
}
