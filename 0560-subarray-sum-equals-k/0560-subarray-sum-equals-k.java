class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);   //because intially prefix sum will be zero
        int res=0;
        int ps=0;
        for(int i=0;i<n;i++){
            ps+=nums[i];
            int rs=ps-k;
            if(map.containsKey(rs)){
                res+=map.get(rs);
            }
            map.put(ps,map.getOrDefault(ps,0)+1);
        }
        return res;
    }
}