public class Matrix_a {

    public static void main(String[] args) {
        int[][] matrix1 = new int[3][3];
        int[][] matrix2 = new int[3][3];
        int[][] sum_matrix = new int[3][3];
        int[][] sub_matrix = new int[3][3];


        System.out.println("Первая матрица:");
        for (int i = 0; i < matrix1.length; i++) {
            matrix1[i] = new int[3];
            for (int j = 0; j < matrix1[i].length; j++) {
                matrix1[i][j] = (int) (Math.random() * 10);
                System.out.print(matrix1[i][j] + "  "); //Вывод первоначальной матрицы
            }
            System.out.println();
        }

        System.out.println("\nВторая матрица:");
        for (int i = 0; i < matrix2.length; i++) {
            matrix2[i] = new int[3];
            for (int j = 0; j < matrix2[i].length; j++) {
                matrix2[i][j] = (int) (Math.random() * 10);
                System.out.print(matrix2[i][j] + "  "); //Вывод первоначальной матрицы
            }
            System.out.println();
        }

        System.out.println("\nСумма матриц:");
        for (int i = 0; i < sum_matrix.length; i++) {
            for (int j = 0; j < sum_matrix[i].length; j++) {
                sum_matrix[i][j] = matrix1[i][j] + matrix2[i][j];
                System.out.print(sum_matrix[i][j] + "\t");
            }
            System.out.println();

        }

        System.out.println("\nРазность матриц:");
        for (int i = 0; i < sub_matrix.length; i++) {
            for (int j = 0; j < sub_matrix[i].length; j++) {
                sub_matrix[i][j] = matrix1[i][j] - matrix2[i][j];
                System.out.print(sub_matrix[i][j] + "\t");
            }
            System.out.println();

        }
    }
}
