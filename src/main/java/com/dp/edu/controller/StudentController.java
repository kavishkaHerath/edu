package com.dp.edu.controller;

import com.dp.edu.model.request.StudentDTO;
import com.dp.edu.model.tables.Student;
import com.dp.edu.response.ResponseMessage;
import com.dp.edu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("students")
@CrossOrigin("*")
public class StudentController {
    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping(value = "/insert/student")
    @ResponseBody
    public ResponseEntity<ResponseMessage> createStudents(@RequestBody StudentDTO student){
        return studentService.createStudent(student);
    }

    @PostMapping(value = "/insert/student/attendanceIn")
    @ResponseBody
    public ResponseEntity<ResponseMessage> insertStudentAttendance(@RequestBody StudentDTO student){
        return studentService.insertStudentAttendance(student);
    }
}
