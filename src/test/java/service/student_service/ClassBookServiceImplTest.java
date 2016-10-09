package service.student_service;

import data.TestData;
import model.group.DotNetGroup;
import model.group.Group;
import model.group.JavaGroup;
import model.group.JavaScriptGroup;
import model.student.Sex;
import model.student.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Stopwatch;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Struct;
import java.util.concurrent.TimeUnit;

import static model.student.Sex.WOMAN;

@RunWith(JUnit4.class)
public class ClassBookServiceImplTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private TestData data = new TestData();
    private ClassBookService service = new ClassBookServiceImpl();
    private Student student_one = new Student("Christy","Walton", 88.17, true, new JavaGroup(), WOMAN, 0.02);
    private Student student_two = new Student("Alice","Walton", 91.19, true, new JavaScriptGroup(), WOMAN, 0.00);
    private Student student_three = new Student("Sam", "Walton", 40.56, true, new DotNetGroup(), WOMAN, 0.41);
    private Student student_four = new Student("Liliane", "Bettencourt", 93.1, true, new DotNetGroup(), WOMAN, 0.23);
    private Student student_five = new Student("Natalia", "Poroschenko", 20.97, true, new DotNetGroup(), WOMAN,0.77);
    private Student student_six = new Student ("Hillary", "Clinton", 74.79, true,new DotNetGroup(), WOMAN, 0.44);
    private Student student_seven = new Student("Evan", "Sharp", 85.77, false, new DotNetGroup(), WOMAN, 0.94);
    private Student student_eight = new Student("Bill","Gates", 99.77, false, new DotNetGroup(), Sex.MAN, 0.88);


    @Before
    public void setUp() throws Exception {
    }
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Rule
    public Stopwatch stopwatch = new Stopwatch() {
        private void logInfo(Description description, long nanos) {
            log.info(String.format("Test %s spent %d microseconds",
                    description.getMethodName(), TimeUnit.NANOSECONDS.toMicros(nanos)));
        }

        @Override
        protected void finished(long nanos, Description description) {
            logInfo(description, nanos);
        }
    };

    @Test
    public void selectStudentByLastNameTest(){
        Assert.assertEquals(student_one + "\n" + student_two + "\n" + student_three + "\n",
                service.getStudentByLastName(data.LIST_OF_STUDENTS, "Walton"));
    }
    @Test
    public void getStudentBySexTest(){
        Assert.assertEquals(student_one + "\n" + student_four + "\n" + student_five + "\n" + student_two + "\n" +
                student_six + "\n" + student_seven + "\n" + student_three + "\n",
                service.getStudentBySex(data.LIST_OF_STUDENTS, Sex.WOMAN));
    }
    @Test
    public void getAllStudentsInGroupTest(){
        Assert.assertEquals(student_eight + "\n" + student_four + "\n" + student_five + "\n" + student_six + "\n" +
                student_seven + "\n" + student_three + "\n",
                service.getAllStudentsInGroup(data.LIST_OF_STUDENTS, new DotNetGroup()));
    }

}