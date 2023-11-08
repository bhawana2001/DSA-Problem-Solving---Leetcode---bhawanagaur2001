class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int n=height.length-1;
        int j=n;
        int max=0;
        while(i<j){
            int hi=height[i];
            int hj=height[j];
            int h=Math.min(hi,hj);
            max=Math.max(max,h*(j-i));
            if(hi<hj){
                i++;
            }else{
            j--;
        }
        }
        return max;
    }
}