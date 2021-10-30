import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;

public class Tests {
    @ParameterizedTest
    @ValueSource(strings = {"100000;13;6;17304.29", "5000000;11;120;68875.01"})
    public void MonthlyPaymentTest(String params){
        // given:
        String[] param = params.split(";");
        double residualAmount = Double.parseDouble(param[0]);
        double rate = Double.parseDouble(param[1]);
        int paymentsRemaining = Integer.parseInt(param[2]);
        double result = Double.parseDouble(param[3]);
        // when:
        double monthlyPayment = Calc.MonthlyPayment(residualAmount, rate, paymentsRemaining);
        // then:
        assertThat(Math.abs(monthlyPayment - result), lessThan(0.009));
    }

    @ParameterizedTest
    @ValueSource(strings = {"100000;13;6;103825.71", "5000000;11;120;8265000.68"})
    public void FullRefundSumTest(String params){
        // given:
        String[] param = params.split(";");
        double creditSum = Double.parseDouble(param[0]);
        double rate = Double.parseDouble(param[1]);
        int months = Integer.parseInt(param[2]);
        double result = Double.parseDouble(param[3]);
        // when:
        double frs = Calc.FullRefundSum(creditSum, rate, months);
        // then:
        assertThat(Math.abs(frs - result), lessThan(0.009));
    }

    @ParameterizedTest
    @ValueSource(strings = {"100000;13;6;3825.71", "5000000;11;120;3265000.68"})
    public void OverpaymentTest(String params){
        // given:
        String[] param = params.split(";");
        double creditSum = Double.parseDouble(param[0]);
        double rate = Double.parseDouble(param[1]);
        int months = Integer.parseInt(param[2]);
        double result = Double.parseDouble(param[3]);
        // when:
        double op = Calc.Overpayment(creditSum, rate, months);
        // then:
        assertThat(Math.abs(op - result), lessThan(0.009));
    }
}
