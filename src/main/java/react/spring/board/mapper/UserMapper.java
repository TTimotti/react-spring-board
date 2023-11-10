package react.spring.board.mapper;

import org.apache.ibatis.annotations.Mapper;
import react.spring.board.entity.TbUser;
import react.spring.board.common.Pagination;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    int selectNextVal();
    int insertUser(TbUser user);
    int selectTotalItems(Pagination pagination);
    Optional<TbUser> selectUser(int idx);
    Optional<TbUser> selectUserById(String id);
    List<TbUser> selectUserList(Pagination pagination);
    int updateUser(TbUser user);
    int deleteUser(int idx);
}