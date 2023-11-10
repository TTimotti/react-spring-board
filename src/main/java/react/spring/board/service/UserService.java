package react.spring.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import react.spring.board.mapper.UserMapper;
import react.spring.board.entity.TbUser;
import react.spring.board.dto.user.InsertUserDto;
import react.spring.board.dto.user.SelectUserDto;
import react.spring.board.dto.user.SelectUserListDto;
import react.spring.board.dto.user.UpdateUserDto;
import react.spring.board.common.exception.CustomErrorCode;
import react.spring.board.common.exception.CustomException;
import react.spring.board.common.Pagination;

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
        TbUser user = mapper.selectUserById(id).orElseThrow(() -> new UsernameNotFoundException("해당 유저가 없음 : " + id));
        log.info("USER={}", user);
        return user;
    }
    @Transactional
    public SelectUserDto insertUser(InsertUserDto dto) {
        dto.setPassword(encoder.encode(dto.getPassword()));
        int index = mapper.selectNextVal();
        TbUser dao = TbUser.builder()
                .idx(index)
                .id(dto.getId())
                .password(dto.getPassword())
                .nickname(dto.getNickname())
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
        TbUser dao = mapper.selectUser(idx).orElseThrow(() -> new CustomException(CustomErrorCode.USER_NOT_FOUND));

        return SelectUserDto.builder()
                .idx(dao.getIdx())
                .id(dao.getId())
                .email(dao.getEmail())
                .phoneNum(dao.getPhoneNum())
                .nickname(dao.getNickname())
                .introduction(dao.getIntroduction())
                .createdDt(dao.getCreatedDt())
                .modifiedDt(dao.getModifiedDt())
                .build();
    }

    public SelectUserListDto selectUserList(Pagination pagination) {
        if (pagination.getKey() == null) {
            throw new CustomException(CustomErrorCode.PARAMETER_NOT_FOUND);
        }

        int total = mapper.selectTotalItems(pagination);
        pagination.paging(total);
        List<TbUser> daoList = mapper.selectUserList(pagination);

        if (pagination.getKey() == null) {
            throw new CustomException(CustomErrorCode.PARAMETER_NOT_FOUND);
        }

        List<SelectUserDto> dtoList = new ArrayList<>();

        for (TbUser dao : daoList) {
            SelectUserDto user = SelectUserDto.builder()
                    .idx(dao.getIdx())
                    .id(dao.getId())
                    .email(dao.getEmail())
                    .phoneNum(dao.getPhoneNum())
                    .nickname(dao.getNickname())
                    .introduction(dao.getIntroduction())
                    .createdDt(dao.getCreatedDt())
                    .modifiedDt(dao.getModifiedDt())
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
        TbUser dao = TbUser.builder()
                .idx(dto.getIdx())
                .nickname(dto.getNickname())
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
