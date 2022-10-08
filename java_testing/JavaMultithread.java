package java_testing;

class TestThread implements Runnable{
    private Thread thread;
    private String threadName;

    TestThread(String name) {
        threadName = name;
        System.out.println("New threadname is " + threadName);
    }

    public void run() {
        System.out.println("Thread: " + threadName + " has begun running");
        try {
            for(int i = 0; i < 10; i++) {
                System.out.println(threadName + ": " + i);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            System.out.println("Thread: " + threadName + " has been interrupted");
        }
        System.out.println("Thread: " + threadName + " has finished running");
    }

    public void start() {
        System.out.println("Thread: " + threadName + " has started");
        // Checking to see if thread exists yet
        if(thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }
}


public class JavaMultithread {
    public static void main(String[] args) {
        TestThread thread1 = new TestThread("Thread 1");
        TestThread thread2 = new TestThread("Thread 2");
        thread1.start();
        thread2.start();
        return;
    }
}