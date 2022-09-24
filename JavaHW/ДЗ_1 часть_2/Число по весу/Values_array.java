public class Values_array {
    private int[] values; // значения
    private int[] weights; // веса
    private int[] ranges; // левые границы отрезков
    private int sum = 0; // общая длина всех отрезков (весов)

    public Values_array(int[] values, int[] weights) {
        this.values = values;
        this.weights = weights;

        for (int weight : weights) {
            sum += weight;
        }

        ranges = new int[sum]; // генерируем новый массив, в котором количество подряд идщих элементов исходного массива повторяется соответственно количеству веса
        int k = 0;
        for (int i = 0; i < this.values.length; i++)
            for (int j = 1; j <= this.weights[i]; j++)
                ranges[k++] = this.values[i];

        }

        public int getRandom() {
            int rand = (int) (Math.random() * (sum - 1));
            return this.ranges[rand];
        }
    }
