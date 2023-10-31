package study.work.signAccess.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.work.signAccess.model.dto.ReadUserDto;
import study.work.signAccess.service.UserService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    @GetMapping(value="/user/{uid}")
    public ReadUserDto selectUser(@PathVariable int uid) {
        log.info("uid : {}", uid);
        return service.selectUser(uid);
    }
}
