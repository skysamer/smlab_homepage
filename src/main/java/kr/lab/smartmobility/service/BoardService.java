package kr.lab.smartmobility.service;

import kr.lab.smartmobility.dao.BoardDAO;
import kr.lab.smartmobility.vo.BoardVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("boardService")
@Log4j2
public class BoardService {

    @Autowired
    private BoardDAO dao;

    public void register(BoardVO vo){
        dao.insert(vo);
    }

    public void modify(BoardVO vo){
        dao.update(vo);
    }

    public void remove(int bno){
        dao.delete(bno);
    }

    public BoardVO get(int bno){
        return dao.get(bno);
    }

    public List<BoardVO> getList(){
        return dao.getList();
    }

    public void mainAnnouncement(BoardVO vo){
        dao.mainAnnouncement(vo);
    }
}
