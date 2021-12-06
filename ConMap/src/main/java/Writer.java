import java.util.concurrent.ConcurrentHashMap;

public class Writer extends Thread {
    private ConcurrentHashMap<Integer, Integer> map;
    private int[] ints;
    private int start;

    public Writer(ConcurrentHashMap<Integer, Integer> map, int[] ints, int start) {
        this.map = map;
        this.ints = ints;
        this.start = start;
    }

    @Override
    public void run() {
        for (int i = start; i < ints.length; i++) {
            map.putIfAbsent(i, ints[i]);
        }
    }
}
