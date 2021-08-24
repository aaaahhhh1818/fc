package org.zerock.fc.controller.sub;

import lombok.extern.log4j.Log4j2;
import org.zerock.fc.annotation.Controller;
import org.zerock.fc.annotation.GetMapping;
import org.zerock.fc.annotation.PostMapping;
import org.zerock.fc.dto.BoardDTO;
import org.zerock.fc.dto.PageDTO;
import org.zerock.fc.dto.PageMaker;
import org.zerock.fc.sevice.BoardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Log4j2
@Controller(value = "/board")
public class BoardController {

    private Integer getInt(String str) {
        try {
            int value = Integer.parseInt(str);
            if(value <= 0) { //페이지 음수값 처리
                return null;
            }
            return value;
        }catch (Exception e) {
            return null;
        }
    }

    @GetMapping(value = "/board/register.do")
    public String registerGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "board/register";
    }

    @PostMapping(value = "/board/register.do")
    public String registerPost(HttpServletRequest request, HttpServletResponse response)throws Exception{

        System.out.println("board register post....do");

        BoardDTO boardDTO = BoardDTO.builder()
                .title(request.getParameter("title"))
                .content(request.getParameter("content"))
                .writer(request.getParameter("writer"))
                .build();

        Integer bno = BoardService.INSTANCE.register(boardDTO);

        return "re:/board/list.do?bno=" + bno;
    }

    @GetMapping(value = "/board/list.do")
    public String list(HttpServletRequest request, HttpServletResponse response)throws Exception{

        Integer page = getInt(request.getParameter("page")); //page -> 숫자 반환 받으려고 !
        Integer size = getInt(request.getParameter("size"));

        PageDTO pageDTO = PageDTO.builder().build();

        if(page != null) { pageDTO.setPage(page); }
        if(size != null) { pageDTO.setSize(size); }

        log.info("===================1");
        log.info(pageDTO);

        List<BoardDTO> dtoList = BoardService.INSTANCE.getList(pageDTO);

        log.info("===================2");
        log.info(dtoList);

        request.setAttribute("dtoList", dtoList); //택배 보내기

        PageMaker pageMaker = new PageMaker(pageDTO.getPage(), pageDTO.getSize(), 1230);

        request.setAttribute("pageMaker", pageMaker);

        return "board/list";
    }

    @GetMapping(value = "/board/read.do")
    public String readGet(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Integer bno = getInt(request.getParameter("bno"));
        Integer page = getInt(request.getParameter("page"));
        Integer size = getInt(request.getParameter("size"));

        //page, size 사용해서 BoardDTO에 담아주기
        PageDTO pageDTO = PageDTO.builder().build();

        if(page != null) { pageDTO.setPage(page); }
        if(size != null) { pageDTO.setSize(size); }

        //페이지 가져오기
        BoardDTO boardDTO = BoardService.INSTANCE.read(bno);

        request.setAttribute("boardDTO", boardDTO);
        request.setAttribute("pageDTO", pageDTO);

        return "board/read";
    }

    @GetMapping(value = "/board/update.do")
    public String updateGet(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Integer bno = getInt(request.getParameter("bno"));

        request.setAttribute("bno", bno);

        return "board/update";
    }

    @PostMapping(value = "/board/update.do")
    public String updatePost(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Integer bno = getInt(request.getParameter("bno"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        BoardDTO boardDTO = BoardDTO.builder()
                .bno(bno)
                .title(title)
                .content(content)
                .build();

        BoardService.INSTANCE.update(boardDTO);

        return "re:/board/read.do?bno=" + bno;
    }

    @PostMapping(value = "/board/delete.do")
    public String deletePost(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Integer bno = Integer.parseInt(request.getParameter("bno"));

        BoardDTO boardDTO = BoardDTO.builder().bno(bno).build();

        BoardService.INSTANCE.delete(bno);

        return "re:/board/list.do?bno=" + bno;
    }

}
