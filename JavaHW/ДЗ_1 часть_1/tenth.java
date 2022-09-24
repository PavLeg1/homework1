import java.util.Scanner;

public class tenth {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int number_1 = in.nextInt();
        System.out.print("Введите второе число: ");
        int number_2 = in.nextInt();

        System.out.printf("Среднее арифметическое двух чисел = %d \n", (number_1 + number_2)/2);
        in.close();

    }

}
