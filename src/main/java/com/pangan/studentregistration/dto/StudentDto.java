package com.pangan.studentregistration.dto;

public record StudentDto (
    Long id,
    String studentId,
    String name,
    String middlename,
    String lastname,
    String address,
    String email,
    String phoneNumber
) {}