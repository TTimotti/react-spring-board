package study.work.signAccess.model.exception;

import lombok.Getter;

@Getter
public enum CustomErrorCode {
    USER_NOT_FOUND("유저 정보가 없습니다"),
    DUPLICATE_USER_ID("이미 사용중인 ID 입니다");

    private final String message;
    CustomErrorCode(String message) {
        this.message = message;
    }

}
