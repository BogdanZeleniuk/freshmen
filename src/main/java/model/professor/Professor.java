package model.professor;

import model.group.Group;
import model.student.Sex;
import model.student.Student;
import service.professor_service.ProfessorService;

import java.util.ArrayList;
import java.util.List;

public class Professor implements ProfessorService {

    private String firstName;
    private String lastName;
    private String subjectName;
    private Sex sex;

    public Professor() {
    }

    public Professor(String firstName, String lastName, String subjectName, Sex sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjectName = subjectName;
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String listOfPresentedStudents(List<Student> allStudents, Group group, boolean presented) {

        List<Student> listOfPresentedStudents = new ArrayList<Student>();
        StringBuilder sb = new StringBuilder();
        for (Student student : allStudents){
            if (group.getName() != null && group.getName().equals(student.getGroup().getName()) && student.isPresented() == presented){
                listOfPresentedStudents.add(student);
            }
        }
        for (Student listOfPresentedStudent : listOfPresentedStudents) {
            sb.append(listOfPresentedStudent).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Professor " +
                 firstName + lastName + ", subjectName='" + subjectName + ", sex=" + sex;
    }
}
