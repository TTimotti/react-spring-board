package study.work.signAccess.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.work.signAccess.mapper.MainMapper;
import study.work.signAccess.model.dao.TbUserDao;
import study.work.signAccess.model.dto.UserDto;

@Service
@RequiredArgsConstructor
public class MainService {
    private final MainMapper mapper;

    public UserDto selectData() {
        TbUserDao dao = mapper.selectData();

        return UserDto.builder()
                .id(dao.getId())
                .title(dao.getTitle())
                .content(dao.getContent())
                .authorId(dao.getAuthorId())
                .createdDt(dao.getCreatedDt())
                .build();
    }
}
