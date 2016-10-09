package service.student_service;

import model.group.Group;
import model.student.HeadOfGroup;
import model.student.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService{

    @Override
    public HeadOfGroup getHeadOfGroup(List<Student> allStudents, Group group) {
        HeadOfGroup head;

        List<Student> filteredByGroup = new ArrayList<Student>();
        for (Student student : allStudents) {
            if (student.getGroup() != null && student.getGroup().getName().equals(group.getName())) {
                filteredByGroup.add(student);
            }
        }
        if (filteredByGroup.size() != 0 && !filteredByGroup.isEmpty()) {
            head = new HeadOfGroup(
                    filteredByGroup.get(0).getFirstName(),
                    filteredByGroup.get(0).getLastName(),
                    filteredByGroup.get(0).getAverageGrade(),
                    filteredByGroup.get(0).isPresented(),
                    filteredByGroup.get(0).getGroup(),
                    filteredByGroup.get(0).getSex(),
                    filteredByGroup.get(0).getPercentOfSkippingLessons());
            for (Student student : filteredByGroup) {
                if (student.getAverageGrade() > head.getAverageGrade()) {
                    head = new HeadOfGroup(
                            student.getFirstName(),
                            student.getLastName(),
                            student.getAverageGrade(),
                            student.isPresented(),
                            student.getGroup(),
                            student.getSex(),
                            student.getPercentOfSkippingLessons());
                } else if (student.getAverageGrade() == head.getAverageGrade()
                        && student.getPercentOfSkippingLessons() < head.getPercentOfSkippingLessons()) {
                    head = new HeadOfGroup(
                            student.getFirstName(),
                            student.getLastName(),
                            student.getAverageGrade(),
                            student.isPresented(),
                            student.getGroup(),
                            student.getSex(),
                            student.getPercentOfSkippingLessons());
                }
            }
        }
        else throw new IndexOutOfBoundsException("You can not choose the Head of Group");
        return head;
    }

}
