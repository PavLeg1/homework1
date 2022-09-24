public class Matrix_d { //D - пункт задания
    public static void main(String[] args) {
        int row = 2, column = 4;
        int[][] matrix = {{5, 6, 7, 8}, {1, 2, 3, 4}};
        show(matrix); // Вывод изначальной матрицы
        int[][] transpose = new int[column][row];
        for (int k = 0; k < row; k++) {
            for (int j = 0; j < column; j++) {
                transpose[j][k] = matrix[k][j]; //Принцип: Транспонировка матрицы (меняются местами коэффициенты)
            }
        }
        show(transpose); //Метод вывода транспонированной матрицы
    }

    public static void show(int[][] matrix) {  //Вывод матрицы
        System.out.println("The matrix is: ");
        for (int[] row : matrix) {
            for (int my_column : row) {
                System.out.print(my_column + "    ");
            }
            System.out.println();
        }
    }
}





