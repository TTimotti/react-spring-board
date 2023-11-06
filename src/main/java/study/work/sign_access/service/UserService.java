package study.work.sign_access.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import study.work.sign_access.mapper.UserMapper;
import study.work.sign_access.model.dao.TbUserDao;
import study.work.sign_access.model.dto.user.InsertUserDto;
import study.work.sign_access.model.dto.user.SelectUserDto;
import study.work.sign_access.model.dto.user.SelectUserListDto;
import study.work.sign_access.model.dto.user.UpdateUserDto;
import study.work.sign_access.model.exception.CustomErrorCode;
import study.work.sign_access.model.exception.CustomException;
import study.work.sign_access.model.util.Pagination;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserMapper mapper;
    private final PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        TbUserDao user = mapper.selectUserById(id).orElseThrow(() -> new UsernameNotFoundException("해당 유저가 없음 : " + id));
        log.info("USER={}", user);
        return user;
    }
    @Transactional
    public SelectUserDto insertUser(InsertUserDto dto) {
        dto.setPassword(encoder.encode(dto.getPassword()));
        int index = mapper.selectNextVal();
        TbUserDao dao = TbUserDao.builder()
                .idx(index)
                .id(dto.getId())
                .password(dto.getPassword())
                .nickname(dto.getName())
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

    public SelectUserDto selectUser(int idx) {
        TbUserDao dao = mapper.selectUser(idx).orElseThrow(() -> new CustomException(CustomErrorCode.USER_NOT_FOUND));

        return SelectUserDto.builder()
                .idx(dao.getIdx())
                .id(dao.getId())
                .email(dao.getEmail())
                .phoneNum(dao.getPhoneNum())
                .name(dao.getNickname())
                .introduction(dao.getIntroduction())
                .createdDt(dao.getCreatedDt())
                .modifiedDt(dao.getModifiedDt())
                .deletedDt(dao.getDeletedDt())
                .build();
    }

    public SelectUserListDto selectUserList(Pagination pagination) {
        int total = mapper.selectTotalItems(pagination);
        pagination.paging(total);
        List<TbUserDao> daoList = mapper.selectUserList(pagination);

        if (CollectionUtils.isEmpty(daoList)) {
            throw new CustomException(CustomErrorCode.USER_NOT_FOUND);
        }

        List<SelectUserDto> dtoList = new ArrayList<>();

        for (TbUserDao dao : daoList) {
            SelectUserDto user = SelectUserDto.builder()
                    .idx(dao.getIdx())
                    .id(dao.getId())
                    .email(dao.getEmail())
                    .phoneNum(dao.getPhoneNum())
                    .name(dao.getNickname())
                    .introduction(dao.getIntroduction())
                    .createdDt(dao.getCreatedDt())
                    .modifiedDt(dao.getModifiedDt())
                    .deletedDt(dao.getDeletedDt())
                    .build();
            dtoList.add(user);
        }

        return SelectUserListDto.builder()
                .userList(dtoList)
                .pagination(pagination)
                .build();
    }
    @Transactional
    public SelectUserDto updateUser(UpdateUserDto dto) {
        TbUserDao dao = TbUserDao.builder()
                .idx(dto.getIdx())
                .nickname(dto.getName())
                .email(dto.getEmail())
                .phoneNum(dto.getPhoneNum())
                .introduction(dto.getIntroduction())
                .build();
        int row = mapper.updateUser(dao);
        if (row > 0){
            return selectUser(dao.getIdx());
        } else {
            throw new CustomException(CustomErrorCode.USER_NOT_FOUND);
        }
    }
    public String deleteUser(int idx) {
        int row = mapper.deleteUser(idx);
        if (row > 0){
            return "DELETE SUCCESS";
        } else {
            throw new CustomException(CustomErrorCode.USER_NOT_FOUND);
        }
    }


}
