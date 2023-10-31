package study.work.signAccess.mapper;

import org.apache.ibatis.annotations.Mapper;
import study.work.signAccess.model.dao.TbUserDao;

import java.util.List;

@Mapper
public interface BoardMapper {
    void insertBoard(TbUserDao user);
    TbUserDao selectBoard(int uid);
    List<TbUserDao> selectBoardList();
    void deleteBoard(int uid);
    void updateBoard(TbUserDao user);
}