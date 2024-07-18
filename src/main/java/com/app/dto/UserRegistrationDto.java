package com.app.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserRegistrationDto {
    private String name;
    private String email;
    private String password;
}
