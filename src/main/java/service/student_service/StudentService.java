package service.student_service;

import model.group.Group;
import model.student.HeadOfGroup;
import model.student.Student;

import java.util.List;


public interface StudentService {

    HeadOfGroup getHeadOfGroup(List<Student> allStudents, Group group);

}
