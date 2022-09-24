import java.util.Scanner;

public class ninth {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = in.nextInt();

        System.out.printf("Ваше число - 21 = %d \n", num - 21);
        in.close();

    }
}
