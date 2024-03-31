package Hello.HelloSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model){
        //RequestParam nullable 여부의 Default는 true이다.
        //http method get으로 localhost:8080/hello-mvc?name={name}의 url이 넘어온다.
        model.addAttribute("name", name);
        //외부에서 data를 전달받아 Model 객체에 저장 후 View page를 반환
        return "hello-template";
    }
}
