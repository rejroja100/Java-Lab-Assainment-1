public class Test {

    public static void main(String[] args) {
        ThreadSafeQueue queue = new ThreadSafeQueue();

        Thread Queue1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    queue.enqueue(i);
                    System.out.println("Enqueued: " + i);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });


        Thread Queue2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    Integer value = queue.dequeue();
                    if (value != null) {
                        System.out.println("Dequeued: " + value);
                    }
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });

        Queue1.start();
        Queue2.start();

        try {
            Queue1.join();
            Queue2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

