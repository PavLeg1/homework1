public class Threads_1 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        new FirstThread("F_Thread").start();
        new SecondThread("S_Thread").start();
    }
}

class FirstThread extends Thread{
    FirstThread(String name){
        super(name);
    }

    public void run(){
        System.out.println("Первый поток запущен \n" + Thread.currentThread().getName());
        try {
            Thread.sleep(100);
        }
        catch(InterruptedException e){
            System.out.println("Поток прерван.");
        }
        System.out.println("Первый поток завершен \n" + Thread.currentThread().getName());
    }
}


class SecondThread extends Thread{
    SecondThread(String name){
        super(name);
    }

    public void run(){
        System.out.println("Второй поток запущен \n" + Thread.currentThread().getName());
        try {
            Thread.sleep(200);
        }
        catch(InterruptedException e){
            System.out.println("Поток прерван.");
        }
        System.out.println("Второй поток завершен \n" + Thread.currentThread().getName());
    }
}