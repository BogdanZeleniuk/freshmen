package service.student_service;

import model.group.Group;
import model.student.Sex;
import model.student.Student;

import java.util.List;

public interface ClassBookService {

    String getStudentByLastName(List<Student> allStudents, String lastName);

    String getAllStudentsInGroup(List<Student> allStudents, Group group);

    String getStudentBySex(List<Student> allStudents, Sex sex);
}
