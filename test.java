import static org.junit.Assert.*;
import org.junit.*;

public class StudentTest {
    private Student student;

    @Before
    public void setUp() {
        student = new Student(1, "sofo", 20);
    }

    @Test
    public void testGetStudentId() {
        assertEquals(1, student.getStudentId());
    }

    @Test
    public void testGetName() {
        assertEquals("sofo", student.getName());
    }

    @Test
    public void testGetAge() {
        assertEquals(20, student.getAge());
    }

    @Test
    public void testEnrollCourse() {
        student.enrollCourse("Math");
        student.enrollCourse("English");
        assertEquals(2, student.getEnrolledCourses().size());
    }
}
