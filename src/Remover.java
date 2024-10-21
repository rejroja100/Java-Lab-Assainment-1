class Remover implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {

            if (!MultipleThread.lists.isEmpty()) {
                Integer removed = MultipleThread.lists.remove(0);
                System.out.println("Removed: " + removed);
            }

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
