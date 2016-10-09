package service.professor_service;

import model.group.Group;
import model.student.Student;

import java.util.List;


public interface ProfessorService {

    String listOfPresentedStudents(List<Student> allStudents, Group group, boolean presented);

}
