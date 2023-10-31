package study.work.signAccess.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.work.signAccess.model.dao.TbUserDao;
import study.work.signAccess.model.dto.UserDto;
import study.work.signAccess.service.MainService;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final MainService service;
    @GetMapping(value="/main")
    public UserDto mainPage() {
        return service.selectData();
    }
}
