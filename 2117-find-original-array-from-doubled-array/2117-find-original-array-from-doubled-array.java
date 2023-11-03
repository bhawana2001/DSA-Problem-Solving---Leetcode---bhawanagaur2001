class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n=changed.length;
        int[] ans=new int[0];
        if(n%2!=0){
            return ans;     
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int ele:changed){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        int[] res=new int[n/2];
        int i=0;
        Arrays.sort(changed);
        for(int ele:changed){
            if(map.get(ele)<=0){
                continue;
            }
            if(map.getOrDefault(ele*2,0)<=0){
                return ans;
            }
            res[i++]=ele;
            map.put(ele,map.get(ele)-1);
            map.put(ele*2,map.get(ele*2)-1);
        }
        return res;
    }
}