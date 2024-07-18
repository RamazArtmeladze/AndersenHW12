package com.app.mapper;

import com.app.dto.UserModelDto;
import com.app.dto.UserRegistrationDto;
import com.app.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
@Component
public class UserModelMapper {
    private PasswordEncoder passwordEncoder;

    public User toEntity (UserRegistrationDto userRegistrationDto) {

        return User.builder()
                .name(userRegistrationDto.getName())
                .email(userRegistrationDto.getEmail())
                .password(passwordEncoder.encode(userRegistrationDto.getPassword()))
                .build();
    }

    public UserModelDto toDto (User user) {

        return UserModelDto.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
