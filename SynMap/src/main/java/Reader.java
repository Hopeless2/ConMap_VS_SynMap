import java.util.Map;

public class Reader extends Thread {
    private Map<Integer, Integer> map;

    public Reader(Map<Integer, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {
        int counter = 0;
        for (int i = 0; i < map.size(); i++) {
            Integer j = map.get(i);
            if (j != null) {
                counter++;
            }
        }
        System.out.println("Количество перебранных элементов в потоке " + Thread.currentThread().getName() + ": " + counter);
    }
}
