package com.dp.edu.service;

import com.dp.edu.model.request.StudentDTO;
import com.dp.edu.model.tables.Center;
import com.dp.edu.model.tables.Student;
import com.dp.edu.repository.CenterRepository;
import com.dp.edu.repository.StudentRepository;
import com.dp.edu.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;

    @Autowired
    private final CenterRepository centerRepository;

    public StudentService(StudentRepository studentRepository, CenterRepository centerRepository) {
        this.studentRepository = studentRepository;
        this.centerRepository = centerRepository;
    }

    public ResponseEntity<ResponseMessage> createStudent(StudentDTO inputStudent){
        try{
            if(studentRepository.existsByEmail(inputStudent.getEmail())){
                return ResponseEntity.ok().body(new ResponseMessage(
                    "-1",
                    "STUDENT ALREADY INSERT",
                    ""
                ));
            }
            var centerCode = inputStudent.getCenterCode();
            var studentCount = studentRepository.countByCenterCode(centerCode) + 1;
            var studentCode = "STU" + centerCode + String.format("%06d", studentCount);

            Center center = centerRepository.findById(centerCode).orElseThrow(
                    () -> new IllegalArgumentException("Invalid Center Code")
            );

            Student student = new Student();
            student.setStudentCode(studentCode);
            student.setName(inputStudent.getStudentName());
            student.setEmail(inputStudent.getEmail());
            student.setCenter(center);
            student.setPhoneNumber(inputStudent.getPhoneNumber());
            student.setParentPhoneNumber(inputStudent.getParentPhoneNumber());
            student.setAddress(inputStudent.getAddress());
            student.setAddDate(new Date());

            studentRepository.save(student);

                return ResponseEntity.ok().body(new ResponseMessage(
                    "0",
                    "success",
                    studentCode
                ));
        }
        catch (Exception e){
            return ResponseEntity.ok().body(new ResponseMessage(
                    "-1",
                    "Failed to insert student: " + e.getMessage(),
                    ""
            ));
        }
    }
}
