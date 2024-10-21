class Adder implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            MultipleThread.lists.add(i);
            System.out.println("Added: " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}