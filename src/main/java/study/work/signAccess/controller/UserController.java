package study.work.signAccess.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.work.signAccess.model.dto.UserDto;
import study.work.signAccess.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    @GetMapping(value="/main/{uid}")
    public UserDto selectUser(@PathVariable int uid) {
        return service.selectUser(uid);
    }
}
