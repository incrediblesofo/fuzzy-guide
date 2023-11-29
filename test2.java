import static org.junit.Assert.*;
import org.junit.*;

public class RegistrationTest {
    private Registration registration;

    @Before
    public void setUp() {
        registration = new Registration();
    }

    @Test
    public void testAddStudent() {
        registration.addStudent(1, "Alice", 25);
        assertEquals(1, registration.students.size());
    }

    @Test
    public void testRegisterStudentToCourse() {
        registration.addStudent(1, "Alice", 25);
        registration.registerStudentToCourse(1, "C++");
        assertEquals(1, registration.students.get(1).getEnrolledCourses().size());
    }

    // Add more test cases as needed for other functionalities in the Registration class
}
