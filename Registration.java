import java.util.*;

class Student {
    private int studentId;
    private String name;
    private int age;
    private List<String> enrolledCourses;

    public Student(int studentId, String name, int age) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        enrolledCourses = new ArrayList<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enrollCourse(String courseName) {
        enrolledCourses.add(courseName);
    }
}

class Registration {
    Map<Integer, Student> students;
    List<String> availableCourses;

    public Registration() {
        students = new HashMap<>();
        availableCourses = new ArrayList<>();
        initializeCourses();
    }

    void initializeCourses() {
        availableCourses.add("Applied Mathematics");
        availableCourses.add("Communicative English");
        availableCourses.add("Entrepreneurship");
        availableCourses.add("C++");
        availableCourses.add("Civics");
    }

    public void addStudent(int studentId, String name, int age) {
        if (!students.containsKey(studentId)) {
            Student student = new Student(studentId, name, age);
            students.put(studentId, student);
            System.out.println("Student " + name + " with ID " + studentId + " registered successfully.");
        } else {
            System.out.println("Student with ID " + studentId + " already exists.");
        }
    }

    public void registerStudentToCourse(int studentId, String courseName) {
        Student student = students.get(studentId);

        if (student != null && availableCourses.contains(courseName)) {
            student.enrollCourse(courseName);
            System.out.println("Student " + student.getName() + " is registered for course: " + courseName);
        } else {
            System.out.println("Student or course not found");
        }
    }

    public void displayEnrolledCourses(int studentId) {
        Student student = students.get(studentId);
        if (student != null) {
            List<String> enrolledCourses = student.getEnrolledCourses();
            System.out.println("Courses enrolled by " + student.getName() + ":");
            for (String course : enrolledCourses) {
                System.out.println(course);
            }
        } else {
            System.out.println("Student not found");
        }
    }
}

public class StudentRegistrationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Registration registration = new Registration();

        while (true) {
            try {
                System.out.println("Enter student ID (integer): ");
                int studentId = Integer.parseInt(scanner.nextLine());

                System.out.println("Enter student name: ");
                String studentName = scanner.nextLine();

                if (studentId <= 0) {
                    throw new IllegalArgumentException("Student ID must be a positive integer.");
                }
                if (studentName.isEmpty()) {
                    throw new IllegalArgumentException("Student name cannot be empty.");
                }

                System.out.println("Enter student age: ");
                int studentAge = Integer.parseInt(scanner.nextLine());

                if (studentAge <= 0) {
                    throw new IllegalArgumentException("Student age must be a positive integer.");
                }

                registration.addStudent(studentId, studentName, studentAge);

                System.out.println("Do you want to register more students? (yes/no): ");
                String choice = scanner.nextLine().toLowerCase();
                if (!choice.equals("yes")) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number for ID or age.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Registering students for courses
        while (true) {
            System.out.println("Enter student ID to register for a course: ");
            int studentId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.println("Available Courses:");
            for (String course : registration.availableCourses) {
                System.out.println(course);
            }

            System.out.println("Enter course name to register: ");
            String courseName = scanner.nextLine().toUpperCase();

            registration.registerStudentToCourse(studentId, courseName);

            System.out.println("Do you want to register more courses for students? (yes/no): ");
            String choice = scanner.nextLine().toLowerCase();
            if (!choice.equals("yes")) {
                break;
            }
        }

        // Displaying enrolled courses for students
        while (true) {
            System.out.println("Enter student ID to display enrolled courses (Enter 0 to exit): ");
            int studentId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (studentId == 0) {
                break;
            }

            registration.displayEnrolledCourses(studentId);
        }

        scanner.close();
    }
}




