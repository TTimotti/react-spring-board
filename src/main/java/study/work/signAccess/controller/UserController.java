package study.work.signAccess.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.work.signAccess.model.dto.user.InsertUserDto;
import study.work.signAccess.model.dto.user.SelectUserDto;
import study.work.signAccess.model.dto.user.SelectUserListDto;
import study.work.signAccess.model.util.Pagination;
import study.work.signAccess.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService service;
    @PostMapping
    public ResponseEntity<SelectUserDto> createUser(@RequestBody InsertUserDto dto) {
        SelectUserDto data = service.insertUser(dto);
        return ResponseEntity.ok(data);
    }
    @GetMapping(value = "/{uid}")
    public ResponseEntity<SelectUserDto> selectUser(@PathVariable int uid) {
        SelectUserDto data = service.selectUser(uid);
        return ResponseEntity.ok(data);
    }
    @GetMapping
    public ResponseEntity<SelectUserListDto> selectUserList(Pagination pagination) {
        SelectUserListDto data = service.selectUserList(pagination);
        return ResponseEntity.ok(data);
    }
    @PatchMapping
    public ResponseEntity<SelectUserDto> updateUser() {
        return null;
    }
    @DeleteMapping
    public ResponseEntity<String> deleteUser() {
        return null;
    }
}
