package study.work.signAccess.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.work.signAccess.mapper.UserMapper;
import study.work.signAccess.model.dao.TbUserDao;
import study.work.signAccess.model.dto.UserDto;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    public UserDto selectUser(int uid) {
        TbUserDao dao = mapper.selectUser(uid);

        return UserDto.builder()
                .id(dao.getId())
                .title(dao.getTitle())
                .content(dao.getContent())
                .authorId(dao.getAuthorId())
                .createdDt(dao.getCreatedDt())
                .build();
    }
}
