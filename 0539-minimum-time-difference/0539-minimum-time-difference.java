import java.util.*;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        int ans = Integer.MAX_VALUE;
        List<Integer> mins = new ArrayList<>();

        for (String s : timePoints) {
            String hr = s.substring(0, 2);
            String min = s.substring(3);
            int h = Integer.parseInt(hr);
            int m = Integer.parseInt(min);
            int time = h * 60 + m;
            mins.add(time);
        }

        Collections.sort(mins);
        
        for (int i = 1; i < mins.size(); i++) {
            ans = Math.min(ans, Math.min(mins.get(i) - mins.get(i - 1), 1440 - (mins.get(i) - mins.get(i - 1))));
        }
        
        ans = Math.min(ans, mins.get(0) + (1440 - mins.get(mins.size() - 1)));

        return ans;
    }
}
