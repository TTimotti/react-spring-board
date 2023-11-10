package react.spring.board.mapper;

import org.apache.ibatis.annotations.Mapper;
import react.spring.board.entity.TbBoard;

import java.util.List;

@Mapper
public interface BoardMapper {
    void insertBoard(TbBoard user);
    TbBoard selectBoard(int uid);
    List<TbBoard> selectBoardList();
    void deleteBoard(int uid);
    void updateBoard(TbBoard user);
}