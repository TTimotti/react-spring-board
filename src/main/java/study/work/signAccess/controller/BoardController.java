package study.work.signAccess.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.work.signAccess.model.dto.ReadBoardDto;
import study.work.signAccess.model.dto.ReadUserDto;
import study.work.signAccess.service.BoardService;
import study.work.signAccess.service.UserService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService service;
    @GetMapping(value="/board/{bid}")
    public ReadBoardDto selectUser(@PathVariable int bid) {
        log.info("uid : {}", bid);
        return service.selectBoard(bid);
    }
}
