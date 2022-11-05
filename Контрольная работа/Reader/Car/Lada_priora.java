public class Lada_priora extends Car{
    private double speed;//Скорость
    private double susp_height; // Высота подвески

    public Lada_priora(String TransClass, double weight, double max_speed, String color, double price, String brand, double susp_height){
        super(TransClass, weight, max_speed, color, price, brand);
        this.susp_height = susp_height;
    }

    public double getSusp_height(){
        return susp_height;
    }

    public void setSusp_height(){
        this.susp_height = susp_height;
    }

    @Override
    public String toString() {
        return "Lada Priora {" +
                "susp_height = " + susp_height +
                "} " + super.toString();
    }


}
