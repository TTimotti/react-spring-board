package react.spring.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import react.spring.board.dto.user.InsertUserDto;
import react.spring.board.dto.user.SelectUserDto;
import react.spring.board.dto.user.SelectUserListDto;
import react.spring.board.dto.user.UpdateUserDto;
import react.spring.board.common.Pagination;
import react.spring.board.service.UserService;

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
    @GetMapping(value = "/{idx}")
    public ResponseEntity<SelectUserDto> selectUser(@PathVariable int idx) {
        SelectUserDto data = service.selectUser(idx);
        return ResponseEntity.ok(data);
    }
    @GetMapping
    public ResponseEntity<SelectUserListDto> selectUserList(Pagination pagination) {
        SelectUserListDto data = service.selectUserList(pagination);
        return ResponseEntity.ok(data);
    }
    @PatchMapping
    public ResponseEntity<SelectUserDto> updateUser(@RequestBody UpdateUserDto dto) {
        SelectUserDto data = service.updateUser(dto);
        return ResponseEntity.ok(data);
    }
    @DeleteMapping(value = "/{idx}")
    public ResponseEntity<String> deleteUser(@PathVariable int idx) {
        String data = service.deleteUser(idx);
        return ResponseEntity.ok(data);
    }
}
