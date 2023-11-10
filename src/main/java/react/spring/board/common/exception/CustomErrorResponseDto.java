package react.spring.board.common.exception;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomErrorResponseDto {
    private CustomErrorCode code;
    private String message;
}
