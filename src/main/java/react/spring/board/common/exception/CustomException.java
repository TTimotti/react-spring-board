package react.spring.board.common.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{

    private final CustomErrorCode customErrorCode;
    private final String detailMessage;

    public CustomException(CustomErrorCode customErrorCode){
        super(customErrorCode.getMessage());
        this.customErrorCode = customErrorCode;
        this.detailMessage = customErrorCode.getMessage();
    }
}
