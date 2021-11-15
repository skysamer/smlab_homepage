package kr.lab.smartmobility.controller;

import kr.lab.smartmobility.service.BoardService;
import kr.lab.smartmobility.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/board/*")
@RestController
@Log4j2
@AllArgsConstructor
public class BoardController {

    @Autowired
    private BoardService service;

    @PostMapping(value = "/register", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> register(@RequestBody BoardVO vo){
        try {
            log.info(vo);
            service.register(vo);
            return new ResponseEntity<String>("글 등록 완료", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("글 등록 실패", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{bno}", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> modify(@RequestBody BoardVO vo, @PathVariable("bno") int bno){
        vo.setBno(bno);

        try {
            service.modify(vo);
            return new ResponseEntity<String>("글 수정 완료", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("글 수정 실패", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{bno}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BoardVO> get(@PathVariable("bno") int bno){

        return new ResponseEntity<BoardVO>(service.get(bno), HttpStatus.OK);
    }

    @GetMapping(value = "/list", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<BoardVO>> getList(){
        return new ResponseEntity<List<BoardVO>>(service.getList(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{bno}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> remove(@PathVariable("bno") int bno){
        try {
            service.remove(bno);
            return new ResponseEntity<String>("글 삭제 완료", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("글 삭제 실패", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(value = "/{bno}", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> mainAnnouncement(@PathVariable("bno") int bno, @RequestBody BoardVO vo){
        log.info(vo);
        vo.setBno(bno);

        try {
            service.mainAnnouncement(vo);
            return new ResponseEntity<String>("메인 공지 등록 완료", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>("메인 공지 등록 실패", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
