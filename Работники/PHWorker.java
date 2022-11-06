package payment;

import java.text.NumberFormat;
import java.util.Locale;


public class PHWorker extends Worker{
    static final double monthly_hours = 8.0 * 20.8;

    private double hourPayment;

    PHWorker(int id, String name, double hp) {
        super(id, name);
        this.hourPayment = hp;
    }

    @Override
    double get_avgSalary() {
        return hourPayment * monthly_hours;
    }

    @Override
    public String toString() {
        NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.US);
        return super.toString() + " в час " + fmt.format(get_avgSalary());
    }

}
