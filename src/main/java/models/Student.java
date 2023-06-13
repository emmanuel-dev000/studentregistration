package models;

import org.springframework.data.annotation.Transient;

public class Student {
    private Long id;
    private String studentId;
    private String name;
    private String address;
    private String email;
    private String phoneNumber;

    @Transient
    public static final String STUDENT_SEQUENCE = "Student Sequence";

    public Student(Long id, String studentId, String name, String address, String email, String phoneNumber) {
        this.id = id;
        this.studentId = studentId;
        this.name = name;
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
}
