package study.work.signAccess.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.work.signAccess.mapper.UserMapper;
import study.work.signAccess.model.dao.TbUserDao;
import study.work.signAccess.model.dto.ReadUserDto;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    public ReadUserDto selectUser(int uid) {
        TbUserDao dao = mapper.selectUser(uid);

        return ReadUserDto.builder()
                .id(dao.getId())
                .name(dao.getName())
                .introduction(dao.getIntroduction())
                .createdDt(dao.getCreatedDt())
                .build();
    }
}
