package study.work.signAccess.mapper;

import org.apache.ibatis.annotations.Mapper;
import study.work.signAccess.model.dao.TbBoardDao;
import study.work.signAccess.model.dao.TbUserDao;

import java.util.List;

@Mapper
public interface BoardMapper {
    void insertBoard(TbBoardDao user);
    TbBoardDao selectBoard(int uid);
    List<TbBoardDao> selectBoardList();
    void deleteBoard(int uid);
    void updateBoard(TbBoardDao user);
}