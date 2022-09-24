public class Main {
    public static void main(String[] args) {
        Ball ball = new Ball(4.5);
        Cylinder cylyinder = new Cylinder(5, 7);
        Pyramid pyramid = new Pyramid(20,20);
        Box box = new Box(100);

        System.out.println(box.add(ball));// Выводит false, так как объем больше вместительности Box
        System.out.println(box.add(cylyinder));//Выводит false, так как объем больше вместительности Box
        System.out.println(box.add(pyramid));//Выводит false, так как объем больше вместительности Box

        Ball ball1 = new Ball(1.5);
        Cylinder cylyinder1 = new Cylinder(2, 2);
        Pyramid pyramid1 = new Pyramid(5,5);
        Box box1 = new Box(1000);

        System.out.println(box.add(ball1));//Выводит true, так как объем довлетворяет условия вместительности Box
        System.out.println(box.add(cylyinder1));//Выводит true, так как объем довлетворяет условия вместительности Box
        System.out.println(box.add(pyramid1));//Выводит true, так как объем довлетворяет условия вместительности Box




    }
}