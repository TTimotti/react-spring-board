package study.work.signAccess.mapper;

import org.apache.ibatis.annotations.Mapper;
import study.work.signAccess.model.dao.TbUserDao;
import study.work.signAccess.model.dto.user.SelectUserDto;
import study.work.signAccess.model.util.Pagination;

import java.util.List;

@Mapper
public interface UserMapper {
    int selectNextVal();
    void insertUser(TbUserDao user);
    TbUserDao selectUser(int uid);
    SelectUserDto selectUserById(String id);
    List<TbUserDao> selectUserList(Pagination pagination);
    void updateUser(TbUserDao user);
    void deleteUser(int uid);


}