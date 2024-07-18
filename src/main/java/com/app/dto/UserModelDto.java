package com.app.dto;

import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserModelDto {
    private Long userId;
    private String name;
    private String email;
}
