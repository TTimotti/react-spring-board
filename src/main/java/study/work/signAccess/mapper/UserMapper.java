package study.work.signAccess.mapper;

import org.apache.ibatis.annotations.Mapper;
import study.work.signAccess.model.dao.TbUserDao;

import java.util.List;

@Mapper
public interface UserMapper {
    void insertUser(TbUserDao user);
    TbUserDao selectUser(int uid);
    List<TbUserDao> selectUserList();
    void deleteUser(int uid);
    void updateUser(TbUserDao user);
}