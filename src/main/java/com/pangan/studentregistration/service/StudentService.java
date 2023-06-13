package com.pangan.studentregistration.service;

import com.pangan.studentregistration.dto.StudentDto;
import com.pangan.studentregistration.model.Student;
import com.pangan.studentregistration.repository.StudentRepository;
import com.pangan.studentregistration.sequence.SequenceGeneratorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final SequenceGeneratorService sequenceGeneratorService;

    public StudentService(StudentRepository studentRepository, SequenceGeneratorService sequenceGeneratorService) {
        this.studentRepository = studentRepository;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    public List<StudentDto> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        List<StudentDto> studentDtoList = new ArrayList<>();
        studentList.forEach(
                student -> {
                    StudentDto studentDto = student.toStudentDto();
                    studentDtoList.add(studentDto);
                });
        return studentDtoList;
    }

    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).get();
        StudentDto studentDto = student.toStudentDto();
        return studentDto;
    }

    public StudentDto createStudentByStudentDto(StudentDto studentDto) {
        long studentId = sequenceGeneratorService.generateSequence(Student.STUDENT_SEQUENCE);
        Student student = new Student(
                studentId,
                studentDto.getStudentId(),
                studentDto.getName(),
                studentDto.getAddress(),
                studentDto.getEmail(),
                studentDto.getPhoneNumber()
        );
        studentRepository.save(student);
        return studentDto;
    }
}
