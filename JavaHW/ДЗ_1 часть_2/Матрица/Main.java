public class Main {

    public static void main(String[] args) {
        int[][] matrix = new int [3][5]; //Задаем размерность двумерного массива

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 10);// Заполняем пустой массив случайными числами
                System.out.print(matrix[i][j] + "  "); //Вывод матрицы
            }
            System.out.println();

        }
    }
}