class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int i=0;
        int j=0;
        int n=s.length();
        int res=0;
        int max=0;
        while(j<n){
            char ch=s.charAt(j);
            if(map.containsKey(ch)){
                while(map.containsKey(ch)){
                map.remove(s.charAt(i));
                i++;
                res=res-1;
                }
            }else{
                map.put(ch,1);
                res++;
                max=Math.max(max,res);
                j++;
            }
        }
        return max;
    }
}