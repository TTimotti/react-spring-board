package study.work.sign_access.mapper;

import org.apache.ibatis.annotations.Mapper;
import study.work.sign_access.model.dao.TbUserDao;
import study.work.sign_access.model.util.Pagination;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    int selectNextVal();
    int insertUser(TbUserDao user);
    int selectTotalItems(Pagination pagination);
    Optional<TbUserDao> selectUser(int idx);
    Optional<TbUserDao> selectUserById(String id);
    List<TbUserDao> selectUserList(Pagination pagination);
    int updateUser(TbUserDao user);
    int deleteUser(int idx);
}