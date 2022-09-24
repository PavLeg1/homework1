import java.util.Scanner;

public class eleventh {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        double number_1 = in.nextDouble();
        System.out.print("Введите второе число: ");
        double number_2 = in.nextDouble();
        double average_geom = Math.sqrt(number_1 * number_2);

        System.out.print("Среднее геометрическое = " + average_geom);
        in.close();

    }
}
