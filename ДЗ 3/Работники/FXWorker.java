package payment;

import java.text.NumberFormat;
import java.util.Locale;


public class FXWorker extends Worker{
    private double monthPayment;

    FXWorker(int id, String name, double mp) {
        super(id, name);
        this.monthPayment = mp;
    }

    @Override
    double get_avgSalary() {
        return monthPayment;
    }

    @Override
    public String toString() {
        NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.US);
        return super.toString() + " фикс. " + fmt.format(get_avgSalary());
    }
}
