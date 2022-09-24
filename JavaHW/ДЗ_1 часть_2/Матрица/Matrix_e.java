public class Matrix_e {

    public static void main(String[] args) {
        int[][] matrix = new int [3][3];
        int[][] degree2_matrix = new int[3][3];
        int[][] degree3_matrix = new int[3][3];

        System.out.println("Первая матрица:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
                System.out.print(matrix[i][j] + "  "); //Вывод первоначальной матрицы1
            }
            System.out.println();
        }

        System.out.println("\nВозведенная в степень 2 матрица:");
        for (int i = 0; i < degree2_matrix.length; i++) {
            for (int j = 0; j < degree2_matrix[i].length; j++) {
                int result = 0;
                for(int k = 0; k< degree2_matrix.length; k++){
                    result += matrix[i][k] * matrix[k][j]; // Матрица умножается сама на себя
                }
                degree2_matrix[i][j] = result;
                System.out.print(degree2_matrix[i][j] + "  "); //Вывод произведения матриц
            }
            System.out.println();
        }

        System.out.println("\nВозведенная в степень 3 матрица:");
        for (int i = 0; i < degree3_matrix.length; i++) {
            for (int j = 0; j < degree3_matrix[i].length; j++) {
                int result = 0;
                for(int k = 0; k< degree3_matrix.length; k++){
                    result += matrix[i][k] * degree2_matrix[k][j]; // Изначальная матрица умножается на себя во второй степени
                }
                degree3_matrix[i][j] = result;
                System.out.print(degree3_matrix[i][j] + "  "); //Вывод произведения матриц
            }
            System.out.println();
        }
    }
}
