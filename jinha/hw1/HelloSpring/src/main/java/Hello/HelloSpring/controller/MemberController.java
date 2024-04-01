package Hello.HelloSpring.controller;

import Hello.HelloSpring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired //Dependency Injection의 3가지 방법 중 1. 생성자 주입
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    //@Autowired private MemberService memberService; //2. 필드 주입_ 별로 추천하지 않는다.

    //@Autowired //3. Setter 주입_ 늘 public으로 열려있어야 하므로 위험.
    //public MemberController(MemberService memberService){
    //    this.memberService = memberService;
    //}

    //생성자 주입 추천!
    //@Autowired는 Spring container에 들어가는 것들만 적용된다.
}
