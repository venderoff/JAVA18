package com.mongoDb.Service.impl;

import com.mongoDb.Service.StudentService;
import com.mongoDb.entity.Student;
import com.mongoDb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository ;
    @Override
    public Student createStudent(Student student) {

        return studentRepository.save(student) ;

    }

    @Override
    public Student getStudentById(String id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Student> getAllStudent() {

     List<Student> elist = studentRepository.findAll() ;

     elist.stream().filter(post -> post.getEmail().equals("irshad@gmail.com")).collect(Collectors.toList());

     List<Student> st = elist.stream().filter(post -> post.getEmail().equals("irshad@gmail.com")).collect(Collectors.toList());
     System.out.println(st);
     for(Student temp: st) {
         System.out.println("name is" + temp.getName()) ;
     }
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Student student) {

        return studentRepository.save(student);
    }

    @Override
    public String deleteStudent(String id) {
        studentRepository.deleteById(id);
        return "Successfully Deleted";
    }

    @Override
    public List<Student> getStudentByName(String name) {
        List<Student> el = studentRepository.findByName(name) ;

return studentRepository.findByName(name) ;
//return el.stream().distinct().collect(Collectors.toList()) ;
//return el.get(0) ;

    }

    @Override
    public Student getOneStudent(String name) {
        List<Student> el = studentRepository.findByName(name) ;

        return el.get(0) ;
    }
}
