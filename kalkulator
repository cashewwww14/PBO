import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the first number: ");
        double number1 = input.nextDouble();
        
        System.out.print("Enter an operator (+, -, *, /):\n"
                         + "'+' for addition\n"
                         + "'-' for subtraction\n"
                         + "'*' for multiplication\n"
                         + "'/' for division\n");
        char operator = input.next().charAt(0);
        
        System.out.print("Enter the second number: ");
        double number2 = input.nextDouble();
        
        double result;
        
        switch (operator) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                if (number2 != 0) {
                    result = number1 / number2;
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                    return;
                }
                break;
            default:
                System.out.println("Error: Invalid operator.");
                return;
        }
        
        System.out.println("Result: " + result);
    }
}
