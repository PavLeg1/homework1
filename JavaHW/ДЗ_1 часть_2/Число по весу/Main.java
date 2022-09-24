public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] v = {1, 2, 3};
        int[] w = {1,2,10};
        Values_array rand = new Values_array(v,w);


        for (int i = 0; i<20; i++) System.out.print(rand.getRandom()+" "); // Генерация случайных чисел в зависимости от веса в пределах [0;20]
        System.out.println();

    }
}