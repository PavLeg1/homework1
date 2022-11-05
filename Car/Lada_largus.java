public class Lada_largus extends Car{
    private int capacity; // Вместимость (людей)

    public Lada_largus(String TransClass, double weight, double max_speed, String color, double price, String brand, int capacity){
        super(TransClass, weight, max_speed, color, price, brand);
        this.capacity = capacity;
    }

    public int getCapacity(){
        return capacity;
    }

    public void setCapacity(){
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Lada largus {" +
                "capacity = " + capacity +
                "} " + super.toString();
    }
}
