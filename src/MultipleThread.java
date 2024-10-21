import java.util.ArrayList;
import java.util.List;

public class MultipleThread {
    static final List<Integer> lists = new ArrayList<>();

    public static void main(String[] args) {
        Thread adderThread = new Thread(new Adder());
        Thread removerThread = new Thread(new Remover());

        adderThread.start();
        removerThread.start();

        try {
            adderThread.join();
            removerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final list: " + lists);
    }
}

