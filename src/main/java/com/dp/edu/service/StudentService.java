package com.dp.edu.service;

import com.dp.edu.model.request.StudentDTO;
import com.dp.edu.model.tables.Center;
import com.dp.edu.model.tables.PC;
import com.dp.edu.model.tables.Student;
import com.dp.edu.repository.CenterRepository;
import com.dp.edu.repository.PCRepository;
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

    @Autowired final PCRepository pcRepository;

    public StudentService(StudentRepository studentRepository, CenterRepository centerRepository, PCRepository pcRepository) {
        this.studentRepository = studentRepository;
        this.centerRepository = centerRepository;
        this.pcRepository = pcRepository;
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

    public ResponseEntity<ResponseMessage> insertStudentAttendance(StudentDTO inputStudent){
        try {
            String centerCode = inputStudent.getPcCode().substring(2,5);

            //first check center is open or not
                //---------------
                //-----------------
                //-------------
            Center center = centerRepository.findById(centerCode).orElseThrow(
                    () -> new IllegalArgumentException("Invalid Center.")
            );
            PC pc = pcRepository.findById(inputStudent.getPcCode()).orElseThrow(
                    () -> new IllegalArgumentException("INVALID PC CODE")
            );
            if(!studentRepository.existsByEmail(inputStudent.getEmail())){
                return ResponseEntity.ok().body(new ResponseMessage(
                        "-1",
                        "STUDENT EMAIL IS INVALID",
                        ""
                ));
            }

            Student student = studentRepository.findByEmail(inputStudent.getEmail());
            return ResponseEntity.ok().body(new ResponseMessage(
                    "0",
                    "success",
                    "center code " + center.getCenterCode() +" and pc code: " + pc.getPcCode() + " Student: " + student.getName()
            ));

        }
        catch (Exception e){
            return ResponseEntity.ok().body(new ResponseMessage(
                    "-1",
                    "Failed to insert student attendance: " + e.getMessage(),
                    ""
            ));
        }
    }
}
