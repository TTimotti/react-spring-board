package react.spring.board.common.exception;

import lombok.Getter;

@Getter
public enum CustomErrorCode {
    USER_NOT_FOUND("유저 정보가 없습니다","DB에 조회하려는 유저의 idx에 해당하는 row가 없음"),
    DUPLICATE_USER_ID("이미 사용중인 ID 입니다", "DB에 사용하려는 유저의 ID에 해당하는 ID가 이미 있음"),
    PARAMETER_NOT_FOUND("요청 파라미터 누락", "서버와의 통신에 필요한 필수 파라미터가 전달되고 있지 않음");

    private final String message;
    private final String detail;
    CustomErrorCode(String message, String detail) {
        this.message = message;
        this.detail = detail;
    }

}
