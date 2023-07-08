package com.controller;

import com.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    //get Method
    @GetMapping("/student")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Student> get() {

        List<String> elist = new ArrayList<>() ;
        elist.add("Eng") ;
        elist.add("Maths") ;

        //Adding headers
        return ResponseEntity.ok().header("custom-header", "usman").body(new Student(1, "Abdul" , "Kalam" , elist));
    }

    //return as a list
@GetMapping("/student/list")
    public ResponseEntity<List<Student>> asList() {
        List<String> elist = new ArrayList<>() ;
        elist.add("Eng") ;
        elist.add("Maths") ;
//        Student st = new Student(1, "Abdul" , "Kalam" , elist) ;
        List<Student> stl = new ArrayList<>() ;
//        stl.add(st) ;
        stl.add(new Student(1, "Abdul" , "Kalam" , elist)) ;
        stl.add(new Student(1, "Vikram" , "seth", elist)) ;
//        return stl ;
//        return ResponseEntity.ok().header("new-header", "xml").body(stl) ;
        return ResponseEntity.ok().header("new-Type", "application/xml").body(stl) ;

    }

    //path Variable
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) {

        List<String> elist = new ArrayList<>() ;
elist.add("Maths") ;
elist.add("Science") ;
elist.add("Geography") ;
        return new ResponseEntity<>(new Student(id , "Rajendra" , "Prasad" , elist) , HttpStatus.OK) ;
    }

    //RequestParams

//    http://localhost:8080/api/student/5/query?first-name=JawaharLal&last-name=Nehru
    @GetMapping("/student/{id}/query")
    public ResponseEntity<Student> reqParam(@RequestParam ("first-name") String fName ,
                                            @RequestParam("last-name") String lName,
                                            @PathVariable("id") int stId
                                            ) {

        return new ResponseEntity<>(new Student(stId , fName , lName , null),HttpStatus.OK) ;
    }

    //POST
    @PostMapping("/student/create")
    public  ResponseEntity<Student> returnPost(@RequestBody Student student) {

        return new ResponseEntity<>(student, HttpStatus.CREATED) ;
    }

    @PutMapping("/student/update/{id}")
public ResponseEntity<Student> puMap(@RequestBody Student std,
                                     @PathVariable("id") int stId) {

        Student student = new Student(stId , std.getFirstName(), std.getLastName(),std.getSubjects()) ;

        return new ResponseEntity<>(student, HttpStatus.OK) ;
    }

    //Delete
    @DeleteMapping("/student/{id}/delete")
    public String delMeth(@PathVariable("id") String id) {

        return "Deleted Successfully" ;
    }
}
