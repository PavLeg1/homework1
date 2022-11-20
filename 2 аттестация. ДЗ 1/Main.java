public class Main{
    public static void main(String[] args){
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}


class Store {
    private int product = 0;
    public synchronized void get(){
        while (product < 1) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }

        product--;
        System.out.println("Куплена единица товара");
        System.out.println("Остаток товара: " + product);
        notify();
    }
    public synchronized void put(){
        while (product >= 5) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        product++;
        System.out.println("Добавлена единица товара");
        System.out.println("Остаток товара: " + product);
        notify();
    }
}


class Consumer implements Runnable {
    Store store;
    public Consumer(Store store){
        this.store = store;
    }
    public void run(){
        for (int i = 1; i < 8; i++){
            store.get();
        }
    }
}


class Producer implements Runnable{
    Store store;
    public Producer(Store store){
        this.store = store;
    }
    public void run(){
        for (int i = 1; i < 8; i++){
            store.put();
        }
    }
}