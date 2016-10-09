package service.student_service;

import model.group.Group;
import model.student.Sex;
import model.student.Student;

import java.util.ArrayList;
import java.util.List;

public class ClassBookServiceImpl implements ClassBookService {

    @Override
    public String getStudentByLastName(List<Student> allStudents, String lastName) {
        StringBuilder sb = new StringBuilder();
        List<Student> listOfStudentsByLastName = new ArrayList<Student>();
        for (Student student : allStudents){
            if (student.getLastName() != null && lastName.equals(student.getLastName())){
                listOfStudentsByLastName.add(student);
            }
        }
        for (Student student : listOfStudentsByLastName) {
            sb.append(student).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String getStudentBySex(List<Student> allStudents, Sex sex) {
        StringBuilder sb = new StringBuilder();
        List<Student> listOfStudentsBySex = new ArrayList<Student>();
        for (Student student : allStudents){
            if (student.getSex() != null && sex.equals(student.getSex())){
                listOfStudentsBySex.add(student);
            }
        }
        for (Student student : listOfStudentsBySex) {
            sb.append(student).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String getAllStudentsInGroup(List<Student> allStudents, Group group) {
        StringBuilder sb = new StringBuilder();
        List<Student> listOfAllStudentsByGroup = new ArrayList<Student>();
        for (Student student : allStudents){
            if (student.getGroup() != null && group.getName().equals(student.getGroup().getName())){
                listOfAllStudentsByGroup.add(student);
            }
        }
        for (Student student : listOfAllStudentsByGroup) {
            sb.append(student).append("\n");
        }
        return sb.toString();
    }
}
