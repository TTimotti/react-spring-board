package study.work.signAccess.model.exception;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
public class CustomException extends RuntimeException{

    private CustomErrorCode customErrorCode;
    private String detailMessage;

    public CustomException(CustomErrorCode customErrorCode){
        super(customErrorCode.getMessage());
        this.customErrorCode = customErrorCode;
        this.detailMessage = customErrorCode.getMessage();
    }
}
