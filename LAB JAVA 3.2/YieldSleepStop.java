class Worker extends Thread {
    volatile boolean running = true;

    Worker(String name) { super(name); }

    public void run() {
        int i = 1;
        while (running) {
            System.out.println(getName() + " : " + i++);
            if (i % 2 == 0) Thread.yield();          // give chance to other threads
            try { Thread.sleep(300); } catch (InterruptedException e) { }  // pause 300 ms
        }
        System.out.println(getName() + " stopped");
    }

    void stopThread() { running = false; }           // replacement for stop()
}

public class YieldSleepStop {
    public static void main(String[] args) throws InterruptedException {
        Worker w1 = new Worker("T1");
        Worker w2 = new Worker("T2");
        w1.start();
        w2.start();

        Thread.sleep(1500);
        w1.stopThread();
        Thread.sleep(1500);
        w2.stopThread();
    }
}