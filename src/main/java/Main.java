import data.TestData;
import model.group.JavaGroup;
import model.group.JavaScriptGroup;
import model.professor.Professor;
import service.student_service.StudentService;
import service.student_service.StudentServiceImpl;

public class Main {
    public static void main(String[] args) {

        StudentService studentService = new StudentServiceImpl();
        TestData data = new TestData();

        //get the hed of group JavaScript
        System.out.println( "The head of Group JavaScript was selected: " +
                studentService.getHeadOfGroup(data.LIST_OF_STUDENTS, new JavaScriptGroup()));

        //check presented students
        System.out.println(new Professor().listOfPresentedStudents(data.LIST_OF_STUDENTS, new JavaGroup(), true));

    }
}
