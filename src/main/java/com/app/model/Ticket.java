package com.app.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Ticket {
    private Long id;
    private Long userId;
    private String ticketType;
    private String ticketClass;
    private LocalDateTime creationDate;
    private LocalDate startDate;
    private int price;
}