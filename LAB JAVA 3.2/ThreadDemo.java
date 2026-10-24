public class ThreadDemo implements Runnable {
    private volatile boolean suspended = false, stopped = false;

    public void run() {
        int i = 0;
        while (!stopped) {
            synchronized (this) {
                while (suspended && !stopped) {
                    try { wait(); } catch (InterruptedException e) { return; }
                }
            }
            System.out.println("Running: " + i++);
            try { Thread.sleep(300); } catch (InterruptedException e) { return; }
        }
        System.out.println("Thread stopped.");
    }

    synchronized void suspendThread() { suspended = true; System.out.println("--- Suspended ---"); }
    synchronized void resumeThread()  { suspended = false; notify(); System.out.println("--- Resumed ---"); }
    synchronized void stopThread()    { stopped = true; notify(); }

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo task = new ThreadDemo();
        Thread t = new Thread(task);
        t.start();

        Thread.sleep(1000);
        task.suspendThread();
        Thread.sleep(1500);
        task.resumeThread();
        Thread.sleep(1000);
        task.stopThread();
        t.join();
    }
}
