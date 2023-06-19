import java.util.*;

public class SnapshotArray {
    int[] data;
    int[] currentData;
    Map<int[], Integer> deltas = new HashMap<>(); // <<snapshot, index>, value>
    ArrayList<Integer> alteredIndexes = new ArrayList<>();
    int currentSnapshot = 0;


    public SnapshotArray(int length) {
        this.data = new int[length];
        Arrays.fill(data, 0);

        this.currentData = new int[length];
        Arrays.fill(currentData, 0);
    }

    public void set(int index, int val) {
        currentData[index] = val;
        alteredIndexes.add(index);
    }

    public int snap() {
        for (int alteredIndex : alteredIndexes) {
            if (currentData[alteredIndex] == data[alteredIndex]) continue;
            int[] deltaKey = new int[] {currentSnapshot, alteredIndex};
            deltas.put(deltaKey, currentData[alteredIndex]);
        }
        alteredIndexes = new ArrayList<>();
        currentSnapshot++;
        return currentSnapshot - 1;
    }

    public int get(int index, int snap_id) {
        while (true) {
            if (index == -1) return 0;

            int[] keyToSearch = new int[] {snap_id, index};

            Integer result = null;

            for (int[] key : deltas.keySet()) {
                if (!Arrays.equals(key, keyToSearch)) continue;
                result = deltas.get(key);
            }

            if (result == null) {
                snap_id--;
                continue;
            }

            return result;
        }
    }
    public static void main(String[] args) {
        SnapshotArray snapshotArray = new SnapshotArray(12);
        snapshotArray.set(0, 12);
        snapshotArray.snap();
        snapshotArray.snap();
        snapshotArray.get(1, 0);
        snapshotArray.get(1, 0);
        snapshotArray.snap();
        snapshotArray.snap();
    }
}