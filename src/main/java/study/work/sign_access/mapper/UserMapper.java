package study.work.sign_access.mapper;

import org.apache.ibatis.annotations.Mapper;
import study.work.sign_access.model.dao.TbUserDao;
import study.work.sign_access.model.util.Pagination;

import java.util.List;

@Mapper
public interface UserMapper {
    int selectNextVal();
    void insertUser(TbUserDao user);
    int selectTotalItems(Pagination pagination);
    TbUserDao selectUser(int idx);
    List<TbUserDao> selectUserList(Pagination pagination);
    void updateUser(TbUserDao user);
    void deleteUser(int idx);


}