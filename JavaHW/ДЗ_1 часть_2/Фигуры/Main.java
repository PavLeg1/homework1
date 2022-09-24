public class Main {
    public static void main(String[] args) {
        Ball ball = new Ball(20);
        Cylinder cylyinder = new Cylinder(2, 2);
        Pyramid pyramid = new Pyramid(10, 10);

        Box box = new Box(1000);

        System.out.println(box.add(pyramid));
        System.out.println(box.add(ball));
        System.out.println(box.add(cylyinder));
    }
}