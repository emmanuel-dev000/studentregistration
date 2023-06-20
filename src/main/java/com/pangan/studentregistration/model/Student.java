package com.pangan.studentregistration.model;

import com.pangan.studentregistration.dto.StudentDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class Student {
    @Transient
    public static final String STUDENT_SEQUENCE = "Student Sequence";

    @Id
    private Long id;
    private String studentId;
    private String name;
    private String middlename;
    private String lastname;
    private String address;
    private String email;
    private String phoneNumber;

    public Student() {
    }

    public Student(Long id, String studentId, String name, String middlename, String lastname, String address, String email, String phoneNumber) {
        this.id = id;
        this.studentId = studentId;
        this.name = name;
        this.middlename = middlename;
        this.lastname = lastname;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public StudentDto toStudentDto() {
        return new StudentDto(
                this.getId(),
                this.getStudentId(),
                this.getName(),
                this.getMiddlename(),
                this.getLastname(),
                this.getAddress(),
                this.getEmail(),
                this.getPhoneNumber()
        );
    }
}
