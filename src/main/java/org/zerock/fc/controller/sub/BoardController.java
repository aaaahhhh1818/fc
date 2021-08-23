package org.zerock.fc.controller.sub;

import org.zerock.fc.annotation.Controller;
import org.zerock.fc.annotation.GetMapping;
import org.zerock.fc.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller(value = "/board")
public class BoardController {

    @PostMapping("/board/register.do")
    public String registerPost(HttpServletRequest request, HttpServletResponse response)throws Exception{

        System.out.println("board register post....do");

        return "re:/board/list.do";
    }

    @GetMapping(value = "/board/list.do")
    public String list(HttpServletRequest request, HttpServletResponse response)throws Exception{

        System.out.println("---------------------------");

        return "board/list";
    }

}
