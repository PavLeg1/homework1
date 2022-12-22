import static java.lang.Math.cos;

public class Equation { // Задача 3
    static final float Eps = (float) 0.001;
    static double func(double x){
        return cos(x*x*x*x*x) + x*x*x*x - 345.3*x - 23;
    }
    static void bisection(double a, double b){
        if (func(a) * func(b) >= 0){
            System.out.println("Не рассмотрены правые 'a' и 'b'.");
            return;
        }
        double c = a;
        while((b - a) >= Eps){
            c = (a+b)/2;
            if (func(c) == 0.0)
                break;
            else if (func(c)*func(a) < 0)
                b = c;
            else
                a = c;
        }
        System.out.println("Корень равен: " + c);
    }
}


