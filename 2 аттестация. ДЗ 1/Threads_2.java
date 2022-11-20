class QueueThread extends Thread {
    private Object lock;

    public QueueThread(Object object) {
        this.lock = object;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
//            while (true) { - Цикл while тоже подходит, но можно ограничиться двумя итерациями, вместо бесконечного цикла
            synchronized (lock) {
                try {
                    System.out.println(getName());
                    lock.notify();
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //   }
}

public class Threads_2{
    public static void main(String[] args){
        Object lock = new Object();
        new QueueThread(lock).start();
        new QueueThread(lock).start();

    }

}

