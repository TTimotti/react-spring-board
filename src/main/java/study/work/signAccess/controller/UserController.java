package study.work.signAccess.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.work.signAccess.model.dto.user.InsertUserDto;
import study.work.signAccess.model.dto.user.SelectUserDto;
import study.work.signAccess.model.exception.CustomException;
import study.work.signAccess.model.util.Pagination;
import study.work.signAccess.service.UserService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService service;
    @PostMapping(value = "")
    public ResponseEntity<SelectUserDto> createUser(@RequestBody InsertUserDto dto) {
        SelectUserDto data = service.insertUser(dto);
        return ResponseEntity.ok(data);
    }
    @GetMapping(value = "/{uid}")
    public ResponseEntity<SelectUserDto> selectUser(@PathVariable int uid) {
        SelectUserDto data = service.selectUser(uid);
        return ResponseEntity.ok(data);
    }
    @GetMapping(value = "")
    public ResponseEntity<List<SelectUserDto>> selectUserList(Pagination pagination) {
        List<SelectUserDto> data = service.selectUserList(pagination);
        return ResponseEntity.ok(data);
    }
    @PatchMapping(value = "")
    public ResponseEntity<SelectUserDto> updateUser() {
        return null;
    }
    @DeleteMapping(value = "")
    public ResponseEntity<String> deleteUser() {
        return null;
    }
}
