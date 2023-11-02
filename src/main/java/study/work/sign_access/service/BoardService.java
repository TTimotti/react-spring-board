package study.work.sign_access.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.work.sign_access.mapper.BoardMapper;
import study.work.sign_access.model.dao.TbBoardDao;
import study.work.sign_access.model.dto.board.ReadBoardDto;

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
