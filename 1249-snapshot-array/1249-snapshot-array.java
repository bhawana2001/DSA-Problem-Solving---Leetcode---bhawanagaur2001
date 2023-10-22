import java.util.*;

class SnapshotArray {
    List<List<Pair<Integer, Integer>>> arr;
    int snapId = 0;

    public SnapshotArray(int length) {
        arr = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            arr.add(new ArrayList<>());
            arr.get(i).add(new Pair<>(0, snapId));
        }
    }

    public void set(int index, int val) {
        List<Pair<Integer, Integer>> snap = arr.get(index);
        Pair<Integer, Integer> lastPair = snap.get(snap.size() - 1);
        if (lastPair.getValue() == snapId) {
            snap.remove(snap.size() - 1);
        }
        snap.add(new Pair<>(val, snapId));
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        List<Pair<Integer, Integer>> snap = arr.get(index);
        int left = 0;
        int right = snap.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int snapId = snap.get(mid).getValue();

            if (snapId == snap_id) {
                return snap.get(mid).getKey();
            } else if (snapId < snap_id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (right >= 0) {
            return snap.get(right).getKey();
        }

        return 0; // Default value if no snapshot found
    }
}


/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */