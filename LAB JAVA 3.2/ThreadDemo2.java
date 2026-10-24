class A extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Thread class: " + i);
            try { Thread.sleep(300); } catch (InterruptedException e) { }
        }
    }
}

class B implements Runnable {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Runnable: " + i);
            try { Thread.sleep(300); } catch (InterruptedException e) { }
        }
    }
}

public class ThreadDemo2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new A();
        Thread t2 = new Thread(new B());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Main finished");
    }
}