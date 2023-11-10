package react.spring.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import react.spring.board.mapper.BoardMapper;
import react.spring.board.entity.TbBoard;
import react.spring.board.dto.board.ReadBoardDto;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper mapper;

    public ReadBoardDto selectBoard(int bid) {
        TbBoard dao = mapper.selectBoard(bid);

        return ReadBoardDto.builder()
                .id(dao.getId())
                .title(dao.getTitle())
                .content(dao.getContent())
                .createdDt(dao.getCreatedDt())
                .authorId(dao.getAuthorId())
                .build();
    }
}
