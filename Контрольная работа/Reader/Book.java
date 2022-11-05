public class Book{
    private String title;

    public Book(String title){
        this.title = title;
    }

    public Book(){
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String infoB(){
        return "Название: " + title;
    }

}
