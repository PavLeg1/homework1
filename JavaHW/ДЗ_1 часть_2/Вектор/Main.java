public class Main {
    public static void main(String[] args){

        Vector_Class vector1 = new Vector_Class(20, 35, -10);
        Vector_Class vector2 = new Vector_Class(42, -8, 31);
        System.out.printf("Вектор 1 : %s  \n" , vector1);
        System.out.printf("Вектор 2 : %s  \n" , vector2);
        System.out.format("Длина вектора 1 : %s\n", vector1.getModule());
        System.out.format("Длина вектора 2 : %s\n", vector2.getModule());
        System.out.format("Скалярное произведение векторов : %s\n", vector1.getScalar(vector2));
        System.out.format("Векторное произведение векторов : %s\n", vector1.getVector(vector2));
        System.out.format("Векторное произведение векторов : %s\n", vector1.add(vector2));
        System.out.format("Векторное произведение векторов : %s\n", vector1.subtract(vector2));
        System.out.format("Угол между векторами : %s\n", vector1.cos(vector2));

    }

}