import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class TimeCompare { // Задача 2
    static void createArray(){
        System.out.print("Задайте размер массива: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] RandNumbers =new int[n];
        for (int i=0;i<RandNumbers.length;i++)
            RandNumbers[i]= ThreadLocalRandom.current().nextInt(-100000,100000);
        System.out.println(Arrays.toString(RandNumbers));

        int x = (int)(Math.random()*((100000-(-100000))+1))+(-100000);
        long timeCons;
        long timeBin;
        long t;
        long dif_t;

        t = System.currentTimeMillis();
        searchConseq(RandNumbers, x);
        timeCons = System.currentTimeMillis()-t;
        System.out.println("\nЗатраченное перебором время: " + timeCons + "\n");

        t = System.currentTimeMillis();
        searchBinary(RandNumbers, x);
        timeBin = System.currentTimeMillis()-t;
        System.out.println("\nЗатраченное двоичным поиском время: " + timeBin + "\n");

        dif_t = timeBin - timeCons;
        System.out.println("\nМетод перебора быстрее на "+ dif_t+" миллисекунд!");
    }

    private static void searchConseq(int RandNumbers[], int x){
        boolean test = false;
        for (int element : RandNumbers) {
            if (element == x) {
                test = true;
                break;
            }
        }
        System.out.println(x + " находится в массиве : " + test);
    }

    private static void searchBinary(int RandNumbers[], int x){
        Arrays.sort(RandNumbers);

        double res = Arrays.binarySearch(RandNumbers, x);
        boolean test = res > 0 ? true : false;
        System.out.println(x + " находится в массиве : " + test);


    }
}
