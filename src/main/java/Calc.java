public class Calc {
    public static double MonthlyPayment(double residualAmount, double rate, int paymentsRemaining) {
        double monthRate = rate / (100 * 12);
        return residualAmount * (monthRate / (1 - Math.pow(1 + monthRate, (-paymentsRemaining))));
    }

    public static double FullRefundSum(double creditSum, double rate, int months){
        double mp = MonthlyPayment(creditSum, rate, months);
        return mp * months;
    }

    public static double Overpayment(double creditSum, double rate, int months){
        double frs = FullRefundSum(creditSum, rate, months);
        return (frs - creditSum);
    }
}
