package study.work.sign_access.mapper;

import org.apache.ibatis.annotations.Mapper;
import study.work.sign_access.model.dao.TbBoardDao;

import java.util.List;

@Mapper
public interface BoardMapper {
    void insertBoard(TbBoardDao user);
    TbBoardDao selectBoard(int uid);
    List<TbBoardDao> selectBoardList();
    void deleteBoard(int uid);
    void updateBoard(TbBoardDao user);
}