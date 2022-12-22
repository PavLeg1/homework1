import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        int swOption;
        System.out.println("|                  МЕНЮ                  |");
        System.out.println("|                Варианты                |");
        System.out.println("|    1. Старт                            |");
        System.out.println("|    2. Информация                       |");
        System.out.println("|    3. Добавить отдельное задание       |");
        System.out.println("|    4. Удалить отдельное задание        |");
        System.out.println("|    5. Изменить отдельное задание       |");
        System.out.println("|    6. Список задач                     |");
        System.out.println("|  Выйти и посмотреть список = !observe  |");

        swOption = Keyin.inInt(" Select option: ");

        switch (swOption) {
            case 1:
                System.out.println("Option 1 selected");
                TM_list tm_list = new TM_list();
                TaskManager tm = new TaskManager(tm_list);
                tm.start();
                break;
            case 2:
                System.out.println("Информация");
                TaskManager.printInfo();
                break;
            case 3:
                System.out.println("Добавить задание");
                TM_list.forceAdd();
                break;
            case 4:
                System.out.println("Удалить задание");
                TM_list.deleteTask();
                break;
            case 5:
                System.out.println("Изменить задание");
                TM_list.editTask();
                break;
            case 6:
                System.out.println("Полный список всех задач");
                SavedOutput.readSavedList();
                break;
            case 7:

            default:
                System.out.println("Такого пункта не существует! ");
                break;
        }

    }
}

class Keyin { // Класс, методы которого обрабатывают корректность ввода данных в меню
    public static void printPrompt(String prompt) {
        System.out.print(prompt + " ");
        System.out.flush(); // метод flush выбрасывает все из буфера в поток вывода System.out
    }

    //Метод, позволяющий убедиться в том, что в буфере потока ввода не осталось данных
    public static void inputFlush() {
        int opt;

        try {
            while ((System.in.available()) != 0)
                opt = System.in.read();
        } catch (java.io.IOException e) {
            System.out.println("Ошибка ввода. Введите число, соответствующее варианту меню");
        }
    }
    public static String inString() {
        int aChar;
        String s = "";
        boolean finished = false;

        while (!finished) {
            try {
                aChar = System.in.read();
                if (aChar < 0 || (char) aChar == '\n')
                    finished = true;
                else if ((char) aChar != '\r')
                    s = s + (char) aChar; // Enter into string
            }

            catch (java.io.IOException e) {
                System.out.println("Ошибка ввода. Введите число, соответствующее варианту меню");
                finished = true;
            }
        }
        return s;
    }

    public static int inInt(String prompt) {
        while (true) {
            inputFlush();
            printPrompt(prompt);
            try {
                return Integer.parseInt(inString().trim());
            }

            catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Нужно число");
            }
        }
    }
}

class TaskManager { // Класс, обрабатывающий и перенимающий методы из класса TM_list
    private boolean app_status = true;
    public static Scanner sc = new Scanner(System.in);
    private final TM_list tm_list;

    public TaskManager(TM_list tm_list){
        this.tm_list = tm_list;
    }

    public void start(){
        mainLoop();
        Input.writeFullList();
        SavedOutput.readSavedList();
    }

    public static void printInfo(){
        System.out.println("Добро пожаловать в консольный планировщик дел!");
        System.out.println("Введите '!observe' чтобы выйти из списка и посмотреть его содержимое.");
        System.out.println("Время выполнения по умолчанию = неделя");
        System.out.println("Структура записи задачи => Имя + ':' + описание задания");
    }



    private void mainLoop(){ // Основной механизм работы, основанный на булевой переменной (статус)
        while(app_status){
            printEnterLine();
            String command = readCommand();
            app_status = executeCommand(command);
        }
    }

    private boolean executeCommand(String command){ //Добавляет команду в список или получает команду выйти и открыть список
        if (observeList(command)) {
            tm_list.printList();
            return false;
        }
        else {
            tm_list.addToList(command);
            return true;
        }
    }

    public void printEnterLine(){
        System.out.print("---->");
    }

    private String readCommand(){
        return sc.nextLine();
    }

    private boolean observeList(String command){
        return command.equals("!observe");
    } //Выход и открытие списка

}


class TM_list{
    public static Scanner tm_scan = new Scanner(System.in);// Для изменения данных / добавления

    // Структура использования списков - информация приходит в tm_list, далее сплитуется и информация до ":" попадает в name_list - это название задания
    // Дата создания и выполнения попадают в creation_date и execution_date соответственно. Такое количество списков сделано для простоты редактирования
    private final ArrayList<String> tm_list = new ArrayList<>(); //Изначальный список, куда приходит инфа из Scanner
    public static ArrayList<String> name_list = new ArrayList<>(); // Список по именам, отспличенный по ":"
//    public static ArrayList<String> full_list = new ArrayList<>(); // Полный список индекс + имя + информация + дата создания/выполнения
    public static ArrayList<String> creation_date = new ArrayList<>(); //Список, куда вносится дата создания
    public static ArrayList<String> execution_date = new ArrayList<>(); //Список, куда вносится дата выполнения
    public static ArrayList<String> detailed_info = new ArrayList<>(); //Список, куда вносится дата выполнения


// Списки static, так как используются в методе, записывающем их содержимое в файл

    public static void forceAdd() throws IOException { // добавление задачи через промежуточный список
        //Конструкция, считывающая строки файла 1 строка = 1 список
        String line1 = Files.readAllLines(Paths.get("tasks.txt")).get(0);
        String line2 = Files.readAllLines(Paths.get("tasks.txt")).get(1);
        String line3 = Files.readAllLines(Paths.get("tasks.txt")).get(2);
        String line4 = Files.readAllLines(Paths.get("tasks.txt")).get(3);

        List<String> myList1 = new ArrayList<>(Arrays.asList(line1.split(","))); //
        List<String> myList2 = new ArrayList<>(Arrays.asList(line2.split(","))); //
        List<String> myList3 = new ArrayList<>(Arrays.asList(line3.split(","))); //
        List<String> myList4 = new ArrayList<>(Arrays.asList(line4.split(","))); //

        System.out.println("Добавьте название задачи: ");
        System.out.print("---->");
        String name = tm_scan.nextLine();
        myList1.add(0, name);

        System.out.println("Добавьте детальную информацию: ");
        System.out.print("---->");
        String dets = tm_scan.nextLine();
        myList2.add(0, dets);

        System.out.println("Сколько дней требуется на исполнение (цифра): ");
        System.out.print("---->");
        int day = tm_scan.nextInt();
        myList4.add(0, changeDate(day)); // Добавляет время (дней) на выполнение

        myList3.add(0, creationDate());

        System.out.println("Добавлено название: " + myList1.get(0));
        System.out.println("Добавлено детальное описание: " + myList2.get(0));
        System.out.println("Добавлена дата создания: " + myList3.get(0));
        System.out.println("Добавлена дата выполнения: " + myList4.get(0));

        String list1 = Arrays.toString(myList1.toArray()).replace("[", "").replace("]", "");
        String list2 = Arrays.toString(myList2.toArray()).replace("[", "").replace("]", "");
        String list3 = Arrays.toString(myList3.toArray()).replace("[", "").replace("]", "");
        String list4 = Arrays.toString(myList4.toArray()).replace("[", "").replace("]", "");

        // Вносятся изменения в финальные списки, откуда инфа записывается в текстовый файл
        name_list.add(list1);
        detailed_info.add(list2);
        creation_date.add(list3);
        execution_date.add(list4);
        Input.writeFullList();
    }

    public static void editTask() throws IOException{ // Выбирается номер задания и поочередно меняются его данные (навзание/описание/время выполнения)
        //Конструкция, считывающая строки файла 1 строка = 1 список
        String line1 = Files.readAllLines(Paths.get("tasks.txt")).get(0);
        String line2 = Files.readAllLines(Paths.get("tasks.txt")).get(1);
        String line3 = Files.readAllLines(Paths.get("tasks.txt")).get(2);
        String line4 = Files.readAllLines(Paths.get("tasks.txt")).get(3);

        //Вызывается список строк из сохраненного файла с записанными заданиями. Нужен для редактирования заданий
        List<String> myList1 = new ArrayList<>(Arrays.asList(line1.split(","))); //
        List<String> myList2 = new ArrayList<>(Arrays.asList(line2.split(","))); //
        List<String> myList3 = new ArrayList<>(Arrays.asList(line3.split(","))); //
        List<String> myList4 = new ArrayList<>(Arrays.asList(line4.split(","))); //


        System.out.println("Название: " + myList1);
        System.out.println("Описание: " + myList2);
        System.out.println("Дата создания" + myList3);
        System.out.println("Дата выполнения" + myList4);

        System.out.println("\nВыберите номер задания: ");
        System.out.print("---->");
        int index = tm_scan.nextInt();
//        System.out.println("\nВыберите что вы хотите изменить: ");
//        System.out.print("---->");
//        String name = tm_scan.nextLine();
//        if (name.equals("название")) {System.out.print("---->"); myList1.set(index-1, tm_scan.nextLine());}
//        if (name.equals("описание")) {System.out.print("---->"); myList2.set(index-1, tm_scan.nextLine());}
//        if (name.equals("дата выполнения")) {System.out.print("---->"); myList4.set(index-1, changeDate(tm_scan.nextInt()));} // необходимо ввести число, сколько дней необходимо на выполнение
//        System.out.println("Измените название задачи1: ");// Дублируется один и тот же метод, потому что первый игнорируется
//        System.out.print("---->");
        String name1 = tm_scan.nextLine();
        myList1.set(index-1, name1);

        System.out.println("\nИзмените название задачи: ");
        System.out.print("---->");
        String name = tm_scan.nextLine();
        myList1.set(index-1, name);

        System.out.println("\nИзмените описание: ");
        System.out.print("---->");
        String dets = tm_scan.nextLine();
        myList2.set(index - 1, dets);

        System.out.println("\nСколько дней потребуется на исполнение (цифра): ");
        System.out.print("---->");
        int day = tm_scan.nextInt();
        myList4.set(index-1, changeDate(day)); // Добавляет время (дней) на выполнение


        System.out.println("\nИзменено название: " + myList1.get(index-1));
        System.out.println("Изменено описание: " + myList2.get(index-1));
        System.out.println("Изменена дата выполнения: " + myList4.get(index-1));

        System.out.println("\nНазвание: " + myList1);
        System.out.println("Описание: " + myList2);
        System.out.println("Дата создания" + myList3);
        System.out.println("Дата выполнения" + myList4);

        String list1 = Arrays.toString(myList1.toArray()).replace("[", "").replace("]", "");
        String list2 = Arrays.toString(myList2.toArray()).replace("[", "").replace("]", "");
        String list3 = Arrays.toString(myList3.toArray()).replace("[", "").replace("]", "");
        String list4 = Arrays.toString(myList4.toArray()).replace("[", "").replace("]", "");

        // Вносятся изменения в финальные списки, откуда инфа записывается в текстовый файл
        name_list.add(list1);
        detailed_info.add(list2);
        creation_date.add(list3);
        execution_date.add(list4);
        Input.writeFullList();
    }

    public static void deleteTask() throws IOException{
        //Конструкция, считывающая строки файла 1 строка = 1 список
        String line1 = Files.readAllLines(Paths.get("tasks.txt")).get(0);
        String line2 = Files.readAllLines(Paths.get("tasks.txt")).get(1);
        String line3 = Files.readAllLines(Paths.get("tasks.txt")).get(2);
        String line4 = Files.readAllLines(Paths.get("tasks.txt")).get(3);

        List<String> myList1 = new ArrayList<>(Arrays.asList(line1.split(","))); //
        List<String> myList2 = new ArrayList<>(Arrays.asList(line2.split(","))); //
        List<String> myList3 = new ArrayList<>(Arrays.asList(line3.split(","))); //
        List<String> myList4 = new ArrayList<>(Arrays.asList(line4.split(","))); //

        System.out.println("Название: " + myList1);
        System.out.println("Описание: " + myList2);
        System.out.println("Дата создания" + myList3);
        System.out.println("Дата выполнения" + myList4);

        System.out.println("\nВыберите номер задания, которое нужно удалить: ");
        System.out.print("---->");
        int index = tm_scan.nextInt();
//        System.out.println("\nВыберите что вы хотите изменить: ");
//        System.out.print("---->");
//        String name = tm_scan.nextLine();
//        if (name.equals("название")) {System.out.print("---->"); myList1.set(index-1, tm_scan.nextLine());}
//        if (name.equals("описание")) {System.out.print("---->"); myList2.set(index-1, tm_scan.nextLine());}
//        if (name.equals("дата выполнения")) {System.out.print("---->"); myList4.set(index-1, changeDate(tm_scan.nextInt()));} // необходимо ввести число, сколько дней необходимо на выполнение
        System.out.println("\nУдалено название задачи: " + myList1.get(index-1));
        myList1.remove(index-1);

        System.out.println("\nУдалено описание: " + myList2.get(index-1));
        myList2.remove(index - 1);

        System.out.println("\nУдалено время исполнения " + myList3.get(index-1));
        myList3.remove(index-1);

        System.out.println("\nУдалено время исполнения " + myList4.get(index-1));
        myList4.remove(index-1);

        System.out.println("\nНазвание: " + myList1);
        System.out.println("Описание: " + myList2);
        System.out.println("Дата создания" + myList3);
        System.out.println("Дата выполнения" + myList4);

        String list1 = Arrays.toString(myList1.toArray()).replace("[", "").replace("]", "");
        String list2 = Arrays.toString(myList2.toArray()).replace("[", "").replace("]", "");
        String list3 = Arrays.toString(myList3.toArray()).replace("[", "").replace("]", "");
        String list4 = Arrays.toString(myList4.toArray()).replace("[", "").replace("]", "");

        // Вносятся изменения в финальные списки, откуда инфа записывается в текстовый файл
        name_list.add(list1);
        detailed_info.add(list2);
        creation_date.add(list3);
        execution_date.add(list4);
        Input.writeFullList();

    }

    public void addToList(String item){
        tm_list.add(item);
    }

    public void splitName(int index){
        try{
        String parts = tm_list.get(index).split("\\:")[0];
        System.out.println((index+1) + ". " + parts); // Вывод индекса построчно (не в отдельном списке)
        name_list.add(parts);}
        catch (ArrayIndexOutOfBoundsException abe){
            System.out.println("Убедитесь, что написали через ':' !"); // Обработка исключения, если отсуствует ":" в написании задания
//            System.out.println(abe.getMessage());

        }
    }

    public void splitDetails(int index){
        try{
        String parts = tm_list.get(index).split("\\:")[1];
//        System.out.println((index+1) + ". " + parts); // Вывод индекса построчно (не в отдельном списке)
        detailed_info.add(parts);}
        catch (ArrayIndexOutOfBoundsException abe){
            System.out.println("Убедитесь, что написали через ':' !"); // Обработка исключения, если отсуствует ":" в написании задания
//            System.out.println(abe.getMessage());
        }
    }


    public void printList(){ //Метод, создающий список дел и задающий индекс при построчном выводе
        System.out.println("Дата создания: " + creationDate());
        for (int index = 0; index < tm_list.size(); index++){
//            outputItemsIndex(index);
            splitName(index);
            splitDetails(index);
//            full_list.add(printItemsIndex(index));
//            full_list.add(creationDate());
//            full_list.add(executionDate());
            creation_date.add(creationDate());
            execution_date.add(executionDate());
            System.out.println("Дата выполнения: " + executionDate());
        }
//        System.out.println(name_list);
//        System.out.println(tm_list);
//        System.out.println(full_list);
//        System.out.println(creation_date);
//        System.out.println(execution_date);
//        System.out.println(detailed_info);



    }

    private static String creationDate(){ //Дата создания
        SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
        Calendar currentDate = Calendar.getInstance();

        return simpleDate.format(currentDate.getTime());
    }

    private static String executionDate(){ // Дата исполнения
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cd = Calendar.getInstance();

        cd.add(Calendar.DAY_OF_YEAR, 7); // увеличивает дату на 7 дней, пусть будет настройкой по умолчанию
        return sdf.format(cd.getTime());
    }

    private static String changeDate(int num){ // Изменение даты исполнения
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cd = Calendar.getInstance();

        cd.add(Calendar.DAY_OF_YEAR, num); // увеличивает дату на n - заданное кол-во, пусть будет настройкой по умолчанию
        return sdf.format(cd.getTime());
    }


    private String printItemsIndex(int index){ //Задается индекс - Этот метод выводит индекс в общий список дел
//        System.out.println((index + 1) + ". " + tm_list.get(index));
       return (index + 1) + ". " + tm_list.get(index); //Это вариант работает, если метод указать как String
    }

//    private void outputItemsIndex(int index){ //Этот метод выводит индекс в промежуточное построчное представление по именам (Что выводится при !observe)
//        System.out.println((index + 1) + ". " + tm_list.get(index));
//       return (index + 1) + ". " + tm_list.get(index); //Это вариант работает, если метод указать как String
//    }

}


class Input{ // Здесь сохраняются основные списки в файл
    // Для сохранения данных полный список full_list выводится в текстовый файл
    // Значение append = false => файл будет перезаписываться
    public static void writeFullList() {
        File myfile = new File("C://Users//Admin//ideaProjects//TaskManager//tasks.txt");
        if (myfile.exists()){
            System.out.println("File exists");
        }
        else {
            System.out.println("Not found");}
        try(FileWriter writer = new FileWriter("tasks.txt", false)){
            //Убирает квадратные скобки, но меняет тип на строковый => не работает по индексам => бесполезно

//            String list1 = Arrays.toString(TM_list.full_list.toArray()).replace("[", "").replace("]", "");
//            String list2 = Arrays.toString(TM_list.name_list.toArray()).replace("[", "").replace("]", "");
//            String list3 = Arrays.toString(TM_list.creation_date.toArray()).replace("[", "").replace("]", "");
//            String list4 = Arrays.toString(TM_list.execution_date.toArray()).replace("[", "").replace("]", "");
//            String list5 = Arrays.toString(TM_list.detailed_info.toArray()).replace("[", "").replace("]", "");
//            String text1 = list1;
//            String text2 = list2;
//            String text3 = list3;
//            String text4 = list4;
//            String text5 = list5;
//            String text1 = String.valueOf(TM_list.full_list);
            String text2 = String.valueOf(TM_list.name_list);
            String text3 = String.valueOf(TM_list.detailed_info);
            String text4 = String.valueOf(TM_list.creation_date);
            String text5 = String.valueOf(TM_list.execution_date);
//            writer.write(text1);
//            writer.append("\n");
            writer.write(text2);
            writer.append("\n");
            writer.write(text3);
            writer.append("\n");
            writer.write(text4);
            writer.append("\n");
            writer.write(text5);
            writer.append("\n");
            writer.flush();
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}

//class Output{ // Вывод сохраненного списка full_list в консоль
//    public static void readFullList(){
//        try(FileReader reader = new FileReader("tasks.txt")){
//            char[] buf = new char[999];
//            int c;
//            while((c = reader.read(buf))>0){
//                if(c < 999){
//                    buf = Arrays.copyOf(buf, c);
//                }
//                System.out.print(buf);
//            }
//        }
//        catch(IOException ex){
//            System.out.println(ex.getMessage());
//        }
//    }
//}

class SavedOutput{ // Вывод сохраненных списков в консоль
    public static void readSavedList(){

        try(FileReader reader = new FileReader("tasks.txt")){
            BufferedReader br = new BufferedReader(new FileReader("tasks.txt"));
            if (br.readLine() == null) {
                System.out.println("\nВ файле пока ничего не было сохранено. ");
            }
            char[] buf = new char[999];
            int c;
            while((c = reader.read(buf))>0){
                if(c < 999){
                    buf = Arrays.copyOf(buf, c);
                }
                System.out.print(buf);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
