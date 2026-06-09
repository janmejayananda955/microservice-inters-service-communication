package com.service1.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthResponseDto {
    private String message;
    private String accessToken;
    private String refreshToken;
}
