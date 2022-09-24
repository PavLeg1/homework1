public class Matrix_c {

    public static void main(String[] args) {
        int[][] matrix1 = new int [3][3];
        int[][] matrix2 = new int [3][3];
        int[][] multiplied_matrix = new int[3][3];

        System.out.println("Первая матрица:");
        for (int i = 0; i < matrix1.length; i++) {
            //matrix1[i] = new int[3];
            for (int j = 0; j < matrix1[i].length; j++) {
                matrix1[i][j] = (int) (Math.random() * 10);
                System.out.print(matrix1[i][j] + "  "); //Вывод первоначальной матрицы1
            }
            System.out.println();
        }

        System.out.println("\nВторая матрица:");
        for (int i = 0; i < matrix2.length; i++) {
            //matrix2[i] = new int[4];
            for (int j = 0; j < matrix2[i].length; j++) {
                matrix2[i][j] = (int) (Math.random() * 10);
                System.out.print(matrix2[i][j] + "  "); //Вывод первоначальной матрицы2
            }
            System.out.println();
        }

        System.out.println("\nПроизведение матриц:");
        for (int i = 0; i < multiplied_matrix.length; i++) {
            for (int j = 0; j < multiplied_matrix[i].length; j++) {
                int result = 0;
                for(int k = 0; k< multiplied_matrix.length; k++){
                    result += matrix1[i][k] * matrix2[k][j];
                }
                multiplied_matrix[i][j] = result;
                System.out.print(multiplied_matrix[i][j] + "  "); //Вывод произведения матриц
            }
            System.out.println();
        }
    }
}
