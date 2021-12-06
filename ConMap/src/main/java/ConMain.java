import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class ConMain {
    private static final int TIMING = 1000;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        int[] ints = new int[1_000_000];
        fillArray(ints);
        Thread writer1 = new Writer(map, ints, 0);
        writer1.start();
        Thread writer2 = new Writer(map, ints, ints.length);
        writer2.start();
        try {
            Thread.sleep(TIMING);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread reader1 = new Reader(map);
        reader1.setName("Читатель 1");
        reader1.start();
        Thread reader2 = new Reader(map);
        reader2.setName("Читатель 2");
        reader2.start();
        try {
            writer1.join();
            writer2.join();
            reader1.join();
            reader2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("Время выполнения программы: " + (end - start) + " миллисекунд");
    }

    public static void fillArray(int[] ints) {
        Random random = new Random();
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(100);
        }
    }
}
