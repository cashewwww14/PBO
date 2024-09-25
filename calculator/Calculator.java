import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double number1 = input.nextDouble();

        System.out.print("Enter an operator (+, -, *, /): ");
        char operator = input.next().charAt(0);

        System.out.print("Enter the second number: ");
        double number2 = input.nextDouble();

        double result = 0;
        switch (operator) {
            case '+':
                result = new Sum().operate(number1, number2);
                break;
            case '-':
                result = new Subtract().operate(number1, number2);
                break;
            case '*':
                result = new Multiply().operate(number1, number2);
                break;
            case '/':
                result = new Divide().operate(number1, number2);
                break;
            default:
                System.out.println("Error: Invalid operator.");
                return;
        }

        System.out.println("Result: " + result);
    }
}
