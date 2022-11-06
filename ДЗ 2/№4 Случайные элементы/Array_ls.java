import java.util.ArrayList;
import java.util.LinkedList;

public class Array_ls {
    public static void checkRuntime() {
        ArrayList<Double> arrayList = new ArrayList<>();
        LinkedList<Double> linkedList = new LinkedList<>();
        final int N = 1000000;
        final int M = 100000;
        long startTime0 = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            arrayList.add(Math.random());
        }
        System.out.println(System.currentTimeMillis() - startTime0); //"Время создания первого списка" Время на тесте = 49мс

        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            linkedList.add(Math.random());
        }
        System.out.println(System.currentTimeMillis() - startTime1); //"Время создания второго списка" Время на тесте = 178мс

        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < M; i++) {
            arrayList.get((int) (Math.random() * (N - 1)));
        }
        System.out.println(System.currentTimeMillis() - startTime2); // 100000 из ArrayList Время на тесте = 4мс

        long startTime3 = System.currentTimeMillis();
        for (int i = 0; i < M; i++) {
            linkedList.get((int) (Math.random() * (N - 1)));
        }
        System.out.println(System.currentTimeMillis() - startTime3); // 100000 из LinkedList Время на тесте = 136339мс
    }

}

