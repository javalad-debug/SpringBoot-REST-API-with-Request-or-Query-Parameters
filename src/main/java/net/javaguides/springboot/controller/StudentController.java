package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // http://localhost:8080/student
    @GetMapping("student")
    public Student getStudent() {
        Student student = new Student(
                "John",
              "Doe",
              1
        );
        return student;
    }
// http://localhost:8080/students
@GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Doe","John",1));
        students.add(new Student("Doe2", "John2", 2));
        students.add(new Student("Doe3", "John3", 3));
        students.add(new Student("Doe4","John4", 4));
        return students;
    }

    // SpringBoot REST API with PATH VARIABLE
    // This {id} is called, URL template variable
    // http://localhost:8080/students/1/John/Doe
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
        @PathVariable("first-name") String firstName,
        @PathVariable("last-name") String lastName){
        return new Student(lastName, firstName, studentId);
    }

    // Spring boot REST API with Request Param
    // http://localhost:8080/students/query?id=1&firstName=Doe&lastName=John
    // id=1 is the query parameter
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        return new Student(lastName, firstName, id);
    }
}
