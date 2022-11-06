package payment;

import java.util.*;


public class Payment {
    public static void main(String[] args) {
        int id = 0;

        Set<Worker> workers = new TreeSet<>();

        workers.add(new FXWorker(++id, "Иванов", 1500));
        workers.add(new FXWorker(++id, "Петров", 2000));
        workers.add(new FXWorker(++id, "Сидоров", 2000));
        workers.add(new PHWorker(++id, "Кузнецов", 17));
        workers.add(new PHWorker(++id, "Петров", 19));


        for ( Worker w : workers )
            System.out.println(w);

    }
}
