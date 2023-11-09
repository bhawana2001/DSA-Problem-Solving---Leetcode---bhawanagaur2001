import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> ans = new ArrayList<>();
        int j = 0;
        //add intervals until we will not find expected interval
        while (j < intervals.length && intervals[j][1] < newInterval[0]) {
            ans.add(List.of(intervals[j][0], intervals[j][1]));
            j++;
        }
        //once we find the interval now we will check and merge overlapped intervals
        while (j < intervals.length && intervals[j][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[j][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[j][1]);
            j++;
        }
        //add merged interval to ans
        ans.add(List.of(newInterval[0], newInterval[1]));
        //now add remaining intervals
        while (j < intervals.length) {
            ans.add(List.of(intervals[j][0], intervals[j][1]));
            j++;
        }
        //convert ans list to array
        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            res[i][0] = ans.get(i).get(0);
            res[i][1] = ans.get(i).get(1);
        }
        return res;
    }
}
