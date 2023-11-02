package study.work.signAccess.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.work.signAccess.model.dto.board.ReadBoardDto;
import study.work.signAccess.service.BoardService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService service;
    @GetMapping(value="/board/{bid}")
    public ResponseEntity<ReadBoardDto> selectUser(@PathVariable int bid) {
        log.info("call selectBoard :: uid : {}", bid);
        ReadBoardDto data = service.selectBoard(bid);
        return ResponseEntity.ok(data);
    }
}
