package com.mongoDb.controller;

import com.mongoDb.Response.ErrorResponse;
import com.mongoDb.Service.StudentService;
import com.mongoDb.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService ;

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
         ;

        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED) ;
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Object> getStudentById(@PathVariable("id") String id) {

        try {
            return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
        }
        catch (Exception e) {
            ErrorResponse err = new ErrorResponse() ;
            err.setMessage(e.getMessage());
            return ResponseEntity.ok(err) ;
        }
        }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<>(studentService.getAllStudent() ,HttpStatus.OK) ;
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {

        return new ResponseEntity<>(studentService.updateStudent(student),HttpStatus.OK) ;
    }

@DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") String id ) {
        return ResponseEntity.ok(studentService.deleteStudent(id)) ;
}

@GetMapping("/byName/{name}")
    public List<Student> getByName (@PathVariable("name") String name) {
        return studentService.getStudentByName(name) ;
}

    @GetMapping("/byOneName/{name}")
    public Student getByOneName (@PathVariable("name") String name) {
        return studentService.getOneStudent(name) ;
    }
}
