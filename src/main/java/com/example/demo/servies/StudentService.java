package com.example.demo.servies;

import com.example.demo.models.StudentsData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private List<StudentsData> students = new ArrayList<>();
    //Id counter
    private int id=0;

    public void enrollStudent(StudentsData student){
        student.setId(String.valueOf(id++));
        students.add(student);
    }

    public List<StudentsData> getStudents(){
        return students;
    }
}
