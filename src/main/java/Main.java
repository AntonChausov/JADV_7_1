import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("What you want to do? \n 0. exit" +
                    "\n 1. calc monthly payment \n 2. calc full refund sum" +
                    "\n 3. calc overpayment");
            input = scanner.nextLine();
            switch (input){
                case "0":
                    return;
                case "1":
                    MonthlyPayment(scanner);
                    break;
                case "2":
                    FullRefundSum(scanner);
                    break;
                case "3":
                    Overpayment(scanner);
                    break;
                default:
                    System.out.println("Try again");
            }
        }
    }

    private static void Overpayment(Scanner scanner) {
        double creditSum = InputDouble(scanner, "Input credit sum");
        double rate = InputDouble(scanner, "Input rate");
        int months = InputInteger(scanner, "Input credit term (in months)");
        double op = Calc.Overpayment(creditSum, rate, months);
        System.out.printf("Overpayment: %.2f \n", op);
    }

    private static void FullRefundSum(Scanner scanner) {
        double creditSum = InputDouble(scanner, "Input credit sum");
        double rate = InputDouble(scanner, "Input rate");
        int months = InputInteger(scanner, "Input credit term (in months)");
        double frs = Calc.FullRefundSum(creditSum, rate, months);
        System.out.printf("Full refund sum: %.2f \n", frs);
    }



    private static void MonthlyPayment(Scanner scanner) {
        double residualAmount = InputDouble(scanner, "Input residual amount");
        double rate = InputDouble(scanner, "Input rate");
        int paymentsRemaining = InputInteger(scanner, "Input how much payments remaining");
        double mp = Calc.MonthlyPayment(residualAmount, rate, paymentsRemaining);
        System.out.printf("Monthly payment: %.2f \n", mp);
    }

    private static int InputInteger(Scanner scanner, String s) {
        System.out.println(s);
        return Integer.parseInt(scanner.nextLine());
    }

    private static double InputDouble(Scanner scanner, String s) {
        System.out.println(s);
        return Double.parseDouble(scanner.nextLine());
    }
}
