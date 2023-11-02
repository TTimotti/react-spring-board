package study.work.signAccess.model.exception;

import lombok.*;
import study.work.signAccess.model.exception.CustomErrorCode;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomErrorResponseDto {
    private CustomErrorCode code;
    private String message;
}
