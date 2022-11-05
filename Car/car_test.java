public class car_test {
    public static void main(String[] args){
        Car car = new Car("Механика", 1000, 200, "Черный", 1500000, "Лада");
        Lada_largus lada_largus = new Lada_largus("Механика", 1200, 180, "Желтый", 2000000, "Лада", 7);
        Lada_priora lada_priora = new Lada_priora("Автомат", 900, 250, "Красный", 1000000, "Лада", 20);

        System.out.println(car);
        System.out.println(lada_largus);
        System.out.println(lada_priora);
    }


}
