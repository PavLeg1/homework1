public class Reader {
    private String name;
    private int number;
    private String date;
    private String phone;
    private String facult;

    public Reader(String name, int number, String facult, String date, String phone){
        this.name = name;
        this.number = number;
        this.facult = facult;
        this.date = date;
        this.phone = phone;
    }

    public Reader(){
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFacult(String facult) {
        this.facult = facult;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public String getPhone() {
        return phone;
    }

    public String getFacult() {
        return facult;
    }

    public void takeBook(String... books) {
        System.out.println("Студент "+ this.name + " взял книги:");
        for (String book : books){
            System.out.println(book);
        }
        System.out.println();
    }

    public void takeBook(int number) {
        System.out.println("Студент " + this.name + " взял " + number + " книги");
    }

    public void returnBook(String... books) {
        System.out.println("Студент " + this.name + " вернул книги:");
        for(String book : books){
            System.out.println(book);
        }
        System.out.println();
    }

    public void returnBook(int number){
        System.out.println("Студент " + this.name + " вернул " + number + " книги");
    }

    public String infoR(){
        return " Имя: " + name + " Номер билета: " + number + " Факультет: "
                + facult + " Дата рождения: " + date + " Телефон: " + phone;
    }

}