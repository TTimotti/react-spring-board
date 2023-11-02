package study.work.signAccess.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.work.signAccess.mapper.BoardMapper;
import study.work.signAccess.model.dao.TbBoardDao;
import study.work.signAccess.model.dto.board.ReadBoardDto;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper mapper;

    public ReadBoardDto selectBoard(int bid) {
        TbBoardDao dao = mapper.selectBoard(bid);
        ReadBoardDto board = ReadBoardDto.builder()
                .id(dao.getId())
                .title(dao.getTitle())
                .content(dao.getContent())
                .createdDt(dao.getCreatedDt())
                .authorId(dao.getAuthorId())
                .build();

        return board;
    }
}
