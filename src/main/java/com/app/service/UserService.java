package com.app.service;

import com.app.dto.UserModelDto;
import com.app.dto.UserRegistrationDto;
import com.app.mapper.UserModelMapper;
import com.app.model.User;
import com.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserModelMapper mapper;

    public UserModelDto registerUser (UserRegistrationDto userRegistrationDto) {
        User userModel = mapper.toEntity(userRegistrationDto);
        User savedUserModel = userRepository.save(userModel);

        return mapper.toDto(savedUserModel);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User userModel = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        return new org.springframework.security.core.userdetails.User(userModel.getEmail(), userModel.getPassword(),new ArrayList<>());
    }
}
