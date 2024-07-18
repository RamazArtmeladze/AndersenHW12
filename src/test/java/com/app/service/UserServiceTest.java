package com.app.service;

import com.app.dto.UserModelDto;
import com.app.dto.UserRegistrationDto;
import com.app.mapper.UserModelMapper;
import com.app.model.Ticket;
import com.app.model.User;
import com.app.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private UserModelMapper mapper;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void registerUser() {

        UserRegistrationDto registrationDto = new UserRegistrationDto("ramaz", "ramaz@lab.com", "password");

        List<Ticket> tickets = new ArrayList<>();
        User user = new User(1L, "ramaz", "ramaz@lab.com", "password", tickets);

        Ticket ticket1 = new Ticket();
        ticket1.setId(1L);
        ticket1.setTicketType("first");
        ticket1.setTicketClass("First Class");
        ticket1.setPrice(100);
        ticket1.setUser(user);
        tickets.add(ticket1);

        Ticket ticket2 = new Ticket();
        ticket2.setId(2L);
        ticket2.setTicketType("second");
        ticket2.setTicketClass("Business Class");
        ticket2.setPrice(200);
        ticket2.setUser(user);
        tickets.add(ticket2);

        when(mapper.toEntity(registrationDto)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);

        UserModelDto userModelDtoMock = new UserModelDto();
        userModelDtoMock.setName(user.getName());
        userModelDtoMock.setEmail(user.getEmail());
        when(mapper.toDto(user)).thenReturn(userModelDtoMock);

        UserModelDto userModelDto = userService.registerUser(registrationDto);

        assertNotNull(userModelDto, "UserModelDto should not be null");
        assertEquals("ramaz", userModelDto.getName());
        assertEquals("ramaz@lab.com", userModelDto.getEmail());
    }
}