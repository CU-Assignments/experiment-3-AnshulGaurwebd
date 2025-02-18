// Anshul Gaur 22BCS13276

import java.util.Scanner;

class EnrollmentException extends Exception {
    public EnrollmentException(String message) {
        super(message);
    }
}

public class Main {
    private static final int MAX_STUDENTS = 5;
    private static int enrolledStudents = 0;
    private static final String REQUIRED_COURSE = "Core Java";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter course name: ");
            String course = scanner.nextLine();
            
            if ("Advanced Java".equalsIgnoreCase(course)) {
                System.out.print("Have you completed " + REQUIRED_COURSE + "? (yes/no): ");
                String response = scanner.nextLine();
                if (!response.equalsIgnoreCase("yes")) {
                    throw new EnrollmentException("Error: You must complete " + REQUIRED_COURSE + " first.");
                }
            }
            
            if (enrolledStudents >= MAX_STUDENTS) {
                throw new EnrollmentException("Error: Course is full.");
            }
            
            enrolledStudents++;
            System.out.println("Enrolled in " + course + " successfully!");
        } catch (EnrollmentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
