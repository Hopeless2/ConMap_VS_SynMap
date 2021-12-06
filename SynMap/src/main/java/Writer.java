import java.util.Map;

public class Writer extends Thread {
    private Map<Integer, Integer> map;
    private int[] ints;
    private int start;

    public Writer(Map<Integer, Integer> map, int[] ints, int start) {
        this.map = map;
        this.ints = ints;
        this.start = start;
    }

    @Override
    public void run() {
        for (int i = start; i < ints.length; i++) {
            map.put(i, ints[i]);
        }
    }
}
