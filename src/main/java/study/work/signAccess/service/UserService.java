package study.work.signAccess.service;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import study.work.signAccess.mapper.UserMapper;
import study.work.signAccess.model.dao.TbUserDao;
import study.work.signAccess.model.dto.user.InsertUserDto;
import study.work.signAccess.model.dto.user.SelectUserDto;
import study.work.signAccess.model.exception.CustomErrorCode;
import study.work.signAccess.model.exception.CustomException;
import study.work.signAccess.model.util.Pagination;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;
    private final PasswordEncoder encoder;

    public SelectUserDto insertUser(InsertUserDto dto) {
        dto.setPassword(encoder.encode(dto.getPassword()));
        int index = mapper.selectNextVal();
        TbUserDao dao = TbUserDao.builder()
                .idx(index)
                .id(dto.getId())
                .password(dto.getPassword())
                .name(dto.getName())
                .email(dto.getEmail())
                .phoneNum(dto.getPhoneNum())
                .introduction(dto.getIntroduction())
                .build();

        try {
            mapper.insertUser(dao);
        } catch (DuplicateKeyException e) {
            throw new CustomException(CustomErrorCode.DUPLICATE_USER_ID);
        }


        return selectUser(index);
    }

    public SelectUserDto selectUser(int uid) {
        TbUserDao dao = mapper.selectUser(uid);
        if (dao == null) {
            throw new CustomException(CustomErrorCode.USER_NOT_FOUND);
        }

        SelectUserDto user = SelectUserDto.builder()
                .index(dao.getIdx())
                .id(dao.getId())
                .password(dao.getPassword())
                .email(dao.getEmail())
                .phoneNum(dao.getPhoneNum())
                .name(dao.getName())
                .introduction(dao.getIntroduction())
                .createdDt(dao.getCreatedDt())
                .modifiedDt(dao.getModifiedDt())
                .deletedDt(dao.getDeletedDt())
                .build();

        return user;
    }

    public List<SelectUserDto> selectUserList(Pagination pagination) {
        List<TbUserDao> daoList = mapper.selectUserList(pagination);

        List<SelectUserDto> userList = new ArrayList<>();
        for (TbUserDao dao : daoList) {
            SelectUserDto user = SelectUserDto.builder()
                    .index(dao.getIdx())
                    .id(dao.getId())
                    .password(dao.getPassword())
                    .email(dao.getEmail())
                    .phoneNum(dao.getPhoneNum())
                    .name(dao.getName())
                    .introduction(dao.getIntroduction())
                    .createdDt(dao.getCreatedDt())
                    .modifiedDt(dao.getModifiedDt())
                    .deletedDt(dao.getDeletedDt())
                    .build();
            userList.add(user);
        }

        return userList;
    }
    public void updateUser() {

    }
    public void deleteUser() {

    }
}
