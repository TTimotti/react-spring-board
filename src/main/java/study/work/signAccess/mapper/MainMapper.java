package study.work.signAccess.mapper;

import org.apache.ibatis.annotations.Mapper;
import study.work.signAccess.model.dao.TbUserDao;

@Mapper
public interface MainMapper {
    TbUserDao selectData();
}
