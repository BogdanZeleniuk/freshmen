package model.student;

import model.group.Group;

public class HeadOfGroup extends Student {

    public HeadOfGroup(String firstName, String lastName, double averageGrade, boolean presented, Group group, Sex sex, double percentOfSkippingLessons) {
        super(firstName, lastName, averageGrade, presented, group, sex, percentOfSkippingLessons);
    }
}
