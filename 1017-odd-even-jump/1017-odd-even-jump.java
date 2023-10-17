class Solution {
    public int oddEvenJumps(int[] arr) {
        int n=arr.length;
        int res=1;
        boolean[] high=new boolean[n];
        boolean[] low=new boolean[n];
        TreeMap<Integer,Integer> map=new TreeMap<>();
        high[n-1]=true;
        low[n-1]=true;
        map.put(arr[n-1],n-1);
        for(int i=n-2;i>=0;i--){
            Map.Entry<Integer,Integer> hi=map.ceilingEntry(arr[i]);
            Map.Entry<Integer,Integer> lo=map.floorEntry(arr[i]);
            if(hi!=null) high[i]=low[(int)hi.getValue()];
            if(lo!=null) low[i]=high[(int)lo.getValue()];
            if(high[i]){
                 res++;
            }
            map.put(arr[i],i);
        }
        return res;
    }
}