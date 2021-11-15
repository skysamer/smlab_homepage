package kr.lab.smartmobility.dao;

import kr.lab.smartmobility.vo.BoardVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Log4j2
@Transactional
public class BoardDAO {

    @PersistenceContext
    private EntityManager em;

    public void insert(BoardVO vo){
        log.info(vo);
        em.persist(vo);
    }

    public void update(BoardVO vo){
        em.merge(vo);
    }

    public void delete(int bno){
        em.remove(em.find(BoardVO.class, bno));
    }

    public BoardVO get(int bno){
        return em.find(BoardVO.class, bno);
    }

    public List<BoardVO> getList(){
        return em.createQuery("from BoardVO b order by b.id desc, b.bno desc").getResultList();
    }

    public void mainAnnouncement(BoardVO vo){
        BoardVO findId = em.find(BoardVO.class, vo.getBno()); //같은 엔티티를 조회한다.
        findId.setId(vo.getId()); //데이터를 수정한다.
    }
}
