public class Matrix_b {

    public static void main(String[] args) {
        int[][]matrix = new int[3][];
        int lambda = 3; // Число, на которое умножается матрица

        System.out.println("Изначальная матрица:");
        for(int i = 0; i < matrix.length; i++){
            matrix[i] = new int[3];
            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = (int)(Math.random()*10);
                System.out.print(matrix[i][j] + "  "); //Вывод первоначальной матрицы
            }
            System.out.println();
        }

        System.out.println("\nИтог:");
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] *= lambda; // Умножение каждого i-го j-го элемента на число
                System.out.print(matrix[i][j] + "  ");//вывод перемноженной матрицы
            }
            System.out.println();
        }
    }
}
