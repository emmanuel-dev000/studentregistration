package com.pangan.studentregistration.service;

import com.pangan.studentregistration.dto.StudentDto;
import com.pangan.studentregistration.model.Student;
import com.pangan.studentregistration.repository.StudentRepository;
import com.pangan.studentregistration.sequence.SequenceGeneratorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return studentList.stream()
                    .map(Student::toStudentDto)
                    .collect(Collectors.toList());
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
                studentDto.getMiddlename(),
                studentDto.getLastname(),
                studentDto.getAddress(),
                studentDto.getEmail(),
                studentDto.getPhoneNumber()
        );
        studentRepository.save(student);
        return studentDto;
    }
}
