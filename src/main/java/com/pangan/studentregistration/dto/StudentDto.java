package com.pangan.studentregistration.dto;

public class StudentDto {
    private String studentId;
    private String name;
    private String address;
    private String email;
    private String phoneNumber;

    public StudentDto(String studentId, String name, String address, String email, String phoneNumber) {
        this.studentId = studentId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}