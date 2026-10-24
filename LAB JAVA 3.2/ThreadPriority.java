class PriorityThread extends Thread {
    PriorityThread(String name) { super(name); }

    public void run() {
        System.out.println(getName() + " running with priority " + getPriority());
    }
}

public class ThreadPriority {
    public static void main(String[] args) {
        PriorityThread low = new PriorityThread("Low");
        PriorityThread norm = new PriorityThread("Normal");
        PriorityThread high = new PriorityThread("High");

        low.setPriority(Thread.MIN_PRIORITY);    // 1
        norm.setPriority(Thread.NORM_PRIORITY);  // 5
        high.setPriority(Thread.MAX_PRIORITY);   // 10

        low.start();
        norm.start();
        high.start();
    }
}