public class fourth {
    public static void main(String[] args){
        int a = 2;
        int b = 3;
        int c = a;
        a = b;
        b = c;

        System.out.println("Первый способ");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        int d = 4;
        int e = 3;
        d = d ^ e;
        e = e ^ d;
        d = d ^ e;
        System.out.println("Второй способ");
        System.out.println(d);
        System.out.println(e);
    }
}
