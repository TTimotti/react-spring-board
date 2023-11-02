package study.work.sign_access.model.exception;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomErrorResponseDto {
    private CustomErrorCode code;
    private String message;
}
