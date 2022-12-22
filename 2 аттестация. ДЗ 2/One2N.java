public class One2N { // Задача 1

    static void increase(int N, int a){
        if (a>N) return;
        System.out.print(a+" ");
        a=a+1;
        increase(N,a);

    }

}
