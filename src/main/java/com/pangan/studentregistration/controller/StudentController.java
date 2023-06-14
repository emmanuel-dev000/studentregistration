package com.pangan.studentregistration.controller;

import com.pangan.studentregistration.dto.StudentDto;
import com.pangan.studentregistration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> studentDtoList = studentService.getAllStudents();
        return new ResponseEntity<>(studentDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long id) {
        StudentDto studentDto = studentService.getStudentById(id);
        return new ResponseEntity<>(studentDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
        StudentDto createdStudentDto = studentService.createStudentByStudentDto(studentDto);
        return new ResponseEntity<>(createdStudentDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id) {
        String message = studentService.deleteStudentById(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PatchMapping("/{id}/student-id")
    public ResponseEntity<StudentDto> updateStudentId(
            @PathVariable("id") Long id, @RequestParam("student-id") String studentId) {
        StudentDto studentDto = studentService.updateStudentIdById(id, studentId);
        return new ResponseEntity<>(studentDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}/name")
    public ResponseEntity<StudentDto> updateStudentName(
            @PathVariable("id") Long id, @RequestParam("name") String name) {
        StudentDto studentDto = studentService.updateStudentNameById(id, name);
        return new ResponseEntity<>(studentDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}/middle-name")
    public ResponseEntity<StudentDto> updateStudentMiddlename(
            @PathVariable("id") Long id, @RequestParam("middle-name") String middlename) {
        StudentDto studentDto = studentService.updateStudentMiddlenameById(id, middlename);
        return new ResponseEntity<>(studentDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}/lastname")
    public ResponseEntity<StudentDto> updateStudentLastname(
            @PathVariable("id") Long id, @RequestParam("lastname") String lastname) {
        StudentDto studentDto = studentService.updateStudentLastnameById(id, lastname);
        return new ResponseEntity<>(studentDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}/address")
    public ResponseEntity<StudentDto> updateStudentAddress(
            @PathVariable("id") Long id, @RequestParam("address") String address) {
        StudentDto studentDto = studentService.updateStudentAddressById(id, address);
        return new ResponseEntity<>(studentDto, HttpStatus.OK);
    }
}
