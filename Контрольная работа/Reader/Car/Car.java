public class Car {
    private String TransClass; // Type of transmission - Коробка передач
    private double weight;
    private double max_speed;
    private String color;
    private double price;
    private String brand;


    public Car(String TransClass, double weight, double max_speed, String color, double price, String brand){
        this.TransClass = TransClass;
        this.weight = weight;
        this.max_speed = max_speed;
        this.color = color;
        this.price = price;
        this.brand = brand;
    }

    public String getTransClass(){
        return TransClass;
    }

    public void setTransClass(String TransClass){
        this.TransClass = TransClass;
    }

    public double getMax_speed(){
        return max_speed;
    }

    public void setMax_speed(double max_speed){
        this.max_speed = max_speed;
    }

    public double getWeight(){
        return weight;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public String getBrand(){
        return brand;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public void start(){
        System.out.println("Starting");
    }

    public void stop(){
        System.out.println("Stopping");
    }

    public void accelerate(){
    }

    @Override
    public String toString(){
        return "Car {" + " Вид коробки " + TransClass + " масса " +  weight + " Максимальная скорость " + max_speed +
                " цвет " + color + " цена " + price + " марка машины " + brand + "}";
    }
}
