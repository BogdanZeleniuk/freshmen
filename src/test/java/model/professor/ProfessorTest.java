package model.professor;


import data.TestData;
import model.group.Group;
import model.group.JavaGroup;
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

import java.util.concurrent.TimeUnit;

import static model.student.Sex.MAN;
import static model.student.Sex.WOMAN;


@RunWith(JUnit4.class)
public class ProfessorTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private Professor professor = new Professor();
    private Group group = new JavaGroup();
    private TestData data = new TestData();
    private Student student_one = new Student ("Christy", "Walton", 88.17, true, new JavaGroup(), WOMAN, 0.02);
    private Student student_two = new Student ("Jeff", "Bezos", 98.1, true, new JavaGroup(), MAN, 0.14);
    private Student student_three = new Student ("Evan", "Spiegel", 77.77, true, new JavaGroup(), MAN, 0.94);


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
    public void checkPresentedStudentsTest(){
        Assert.assertEquals(student_one+"\n"+student_two+"\n"+student_three+"\n",
                professor.listOfPresentedStudents(data.LIST_OF_STUDENTS, group, true));
    }


}