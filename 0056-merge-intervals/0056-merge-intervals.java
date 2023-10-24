import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int n=intervals.length;
        List<int[]> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(ans.size()==0 || ans.get(ans.size()-1)[1]<intervals[i][0]){
                ans.add(intervals[i]);
            }else{
                ans.set(ans.size() - 1, new int[]{ans.get(ans.size() - 1)[0], Math.max(ans.get(ans.size() - 1)[1], intervals[i][1])});
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}