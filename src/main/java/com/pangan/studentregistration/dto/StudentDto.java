package com.pangan.studentregistration.dto;

public record StudentDto (
    String studentId,
    String name,
    String middlename,
    String lastname,
    String address,
    String email,
    String phoneNumber
) {}