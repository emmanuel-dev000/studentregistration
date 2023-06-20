package com.pangan.studentregistration.service;

import com.pangan.studentregistration.dto.StudentDto;
import com.pangan.studentregistration.model.Student;
import com.pangan.studentregistration.repository.StudentRepository;
import com.pangan.studentregistration.sequence.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    public static final String STUDENT_REMOVED_FROM_THE_DATABASE = "Student removed from the database";
//    private final SequenceGeneratorService sequenceGeneratorService;
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository/*, SequenceGeneratorService sequenceGeneratorService*/) {
        this.studentRepository = studentRepository;
//        this.sequenceGeneratorService = sequenceGeneratorService;
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
        long studentId = 1L;
        Student student = new Student(
                studentId,
                studentDto.studentId(),
                studentDto.name(),
                studentDto.middlename(),
                studentDto.lastname(),
                studentDto.address(),
                studentDto.email(),
                studentDto.phoneNumber()
        );
        studentRepository.save(student);
        return studentDto;
    }

    public String deleteStudentById(Long id) {
        studentRepository.deleteById(id);
        return STUDENT_REMOVED_FROM_THE_DATABASE;
    }

    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        Student student = studentRepository.findById(id).get();

        if (!student.getStudentId().equals(studentDto.studentId())) {
            student.setStudentId(studentDto.studentId());
        }

        if (!student.getName().equals(studentDto.name())) {
            student.setName(studentDto.name());
        }

        if (!student.getMiddlename().equals(studentDto.middlename())) {
            student.setMiddlename(studentDto.middlename());
        }

        if (!student.getLastname().equals(studentDto.lastname())) {
            student.setLastname(studentDto.lastname());
        }

        if (!student.getAddress().equals(studentDto.address())) {
            student.setAddress(studentDto.address());
        }

        if (!student.getEmail().equals(studentDto.email())) {
            student.setEmail(studentDto.email());
        }

        if (!student.getPhoneNumber().equals(studentDto.phoneNumber())) {
            student.setPhoneNumber(studentDto.phoneNumber());
        }

        return studentRepository.save(student).toStudentDto();
    }

    public StudentDto updateStudentIdById(Long id, String studentId) {
        Student student = studentRepository.findById(id).get();
        student.setStudentId(studentId);
        return studentRepository.save(student).toStudentDto();
    }

    public StudentDto updateStudentNameById(Long id, String studentName) {
        Student student = studentRepository.findById(id).get();
        student.setName(studentName);
        return studentRepository.save(student).toStudentDto();
    }

    public StudentDto updateStudentMiddlenameById(Long id, String studentMiddlename) {
        Student student = studentRepository.findById(id).get();
        student.setMiddlename(studentMiddlename);
        return studentRepository.save(student).toStudentDto();
    }

    public StudentDto updateStudentLastnameById(Long id, String studentLastname) {
        Student student = studentRepository.findById(id).get();
        student.setLastname(studentLastname);
        return studentRepository.save(student).toStudentDto();
    }

    public StudentDto updateStudentAddressById(Long id, String studentAddress) {
        Student student = studentRepository.findById(id).get();
        student.setAddress(studentAddress);
        return studentRepository.save(student).toStudentDto();
    }
}
