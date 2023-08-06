package com.mongoDb.Service;

import com.mongoDb.entity.Student;
import com.mongoDb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    public Student createStudent(Student student) ;

    public Student getStudentById(String id) ;

    public List<Student> getAllStudent() ;

    public Student updateStudent(Student student) ;

    public String deleteStudent(String id) ;

//    public List<Student> getStudentByName(String name) ;
    public List<Student> getStudentByName(String name) ;

    public Student getOneStudent(String name) ;
}
