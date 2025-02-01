package com.dp.edu.service;

import com.dp.edu.model.tables.Student;
import com.dp.edu.repository.StudentRepository;
import com.dp.edu.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public ResponseEntity<ResponseMessage> createStudent(Student student){
        try{
                if(studentRepository.existsByEmail(student.getEmail())){
                    return ResponseEntity.ok().body(new ResponseMessage(
                            "-1",
                            "STUDENT ALREADY INSERT",
                            ""
                    ));
                }
                var center = student.getCenter().getCenterCode();
                var studentCount = studentRepository.countByCenterCode(center);
                System.out.println(studentCount);

                return ResponseEntity.ok().body(new ResponseMessage(
                    "0",
                    "STUDENT ALREADY INSERT",
                    ""
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
