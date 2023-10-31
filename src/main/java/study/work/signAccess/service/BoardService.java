package study.work.signAccess.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.work.signAccess.mapper.BoardMapper;
import study.work.signAccess.mapper.UserMapper;
import study.work.signAccess.model.dao.TbBoardDao;
import study.work.signAccess.model.dao.TbUserDao;
import study.work.signAccess.model.dto.ReadBoardDto;
import study.work.signAccess.model.dto.ReadUserDto;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper mapper;

    public ReadBoardDto selectBoard(int bid) {
        TbBoardDao dao = mapper.selectBoard(bid);

        return ReadBoardDto.builder()
                .id(dao.getId())
                .title(dao.getTitle())
                .content(dao.getContent())
                .createdDt(dao.getCreatedDt())
                .authorId(dao.getAuthorId())
                .build();
    }
}
