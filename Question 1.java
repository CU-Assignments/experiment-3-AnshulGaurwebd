//Anshul Gaur 22BCS13276

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        
        try {
            double value = input.nextDouble();
            if (value < 0) {
                throw new IllegalArgumentException("Oops! Square root of a negative number is not allowed.");
            }
            System.out.println("Computed Square Root: " + Math.sqrt(value));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Invalid input detected! Kindly enter a valid number.");
        } finally {
            input.close();
        }
    }
}
