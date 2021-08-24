package org.zerock.fc.sevice;

import lombok.extern.log4j.Log4j2;
import org.zerock.fc.dao.BoardDAO;
import org.zerock.fc.dto.BoardDTO;
import org.zerock.fc.dto.PageDTO;

import java.util.List;

@Log4j2
public enum BoardService {

    INSTANCE;


    public void delete(Integer bno) throws RuntimeException {

        BoardDAO.INSTANCE.delete(bno);

    }

    public void update(BoardDTO boardDTO) throws RuntimeException {

        BoardDAO.INSTANCE.update(boardDTO);

    }

    public Integer register(BoardDTO boardDTO) throws RuntimeException {

        return BoardDAO.INSTANCE.insert(boardDTO);

    }

    public List<BoardDTO> getList(PageDTO pageDTO) throws RuntimeException { //파라미터? -> PageDTO가 pase, size 갖고 있기때문

        log.info("BoardService getList.............");
        log.info(pageDTO);

        return BoardDAO.INSTANCE.list(pageDTO);

    }

    public BoardDTO read(Integer bno) throws RuntimeException {

        log.info("BoardService read......................" + bno);

        return BoardDAO.INSTANCE.select(bno);

    }

}
