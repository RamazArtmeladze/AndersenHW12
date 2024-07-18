package com.app.controller;

import com.app.dto.UserModelDto;
import com.app.dto.UserRegistrationDto;
import com.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/userRegistration")
    public ResponseEntity<UserModelDto> registerUserModel (@RequestBody UserRegistrationDto userRegistrationDto){
        UserModelDto userModelDto = userService.registerUser(userRegistrationDto);

        return new ResponseEntity<>(userModelDto, HttpStatus.CREATED);
    }
}