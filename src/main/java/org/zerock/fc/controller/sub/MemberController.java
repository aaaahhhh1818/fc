package org.zerock.fc.controller.sub;

import org.zerock.fc.annotation.Controller;
import org.zerock.fc.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller(value = "/member")
public class MemberController {

    @GetMapping("/member/signup.do")
    public String singup(HttpServletRequest request, HttpServletResponse response){
        System.out.println("member signup..................");

        return null;
    }

    @GetMapping("/member/signup.do")
    public String login(HttpServletRequest request, HttpServletResponse response){
        System.out.println("member login..................");

        return null;
    }
}
