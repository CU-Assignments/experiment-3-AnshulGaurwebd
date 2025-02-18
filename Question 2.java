// Anshul gaur 22BCS13276
import java.util.Scanner;

class PinMismatchException extends Exception {
    public PinMismatchException(String message) {
        super(message);
    }
}

class LowBalanceException extends Exception {
    public LowBalanceException(String message) {
        super(message);
    }
}

public class Main {
    private static final int CORRECT_PIN = 4321;
    private static double accountBalance = 3000;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        try {
            System.out.print("Enter your PIN: ");
            int userPin = input.nextInt();
            
            if (userPin != CORRECT_PIN) {
                throw new PinMismatchException("Access Denied: Incorrect PIN.");
            }
            
            System.out.print("Enter withdrawal amount: ");
            double withdrawAmount = input.nextDouble();
            
            if (withdrawAmount > accountBalance) {
                throw new LowBalanceException("Transaction Failed: Insufficient funds.");
            }
            
            accountBalance -= withdrawAmount;
            System.out.println("Transaction Successful! Available Balance: " + accountBalance);
        } catch (PinMismatchException | LowBalanceException ex) {
            System.out.println(ex.getMessage() + " Remaining Balance: " + accountBalance);
        } catch (Exception ex) {
            System.out.println("Error: Invalid input. Please provide numeric values only.");
        } finally {
            input.close();
        }
    }
}
