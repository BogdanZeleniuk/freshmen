package service.student_service;


import data.TestData;
import model.group.Group;
import model.group.JavaGroup;
import model.student.HeadOfGroup;
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

@RunWith(JUnit4.class)
public class StudentServiceImplTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private Group group = new JavaGroup();
    private TestData data = new TestData();
    private StudentService service = new StudentServiceImpl();
    private Student student_one = new HeadOfGroup("Mark", "Zuckenberg", 99.77, false, new JavaGroup(), MAN, 0.77);

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
    public void selectHeadTest(){
        Assert.assertEquals(student_one.toString(),
                service.getHeadOfGroup(data.LIST_OF_STUDENTS, group).toString());
    }
}