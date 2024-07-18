package com.app.dto;

import lombok.*;

@Builder
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class UserRegistrationDto {
    private String name;
    private String email;
    private String password;
}
