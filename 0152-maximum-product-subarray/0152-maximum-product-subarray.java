class Solution {
    public int maxProduct(int[] nums){
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        int pro=1;
        int pro2=1;
        int max2=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            pro*=nums[i];
            max=Math.max(max,pro);
	    if(pro==0){
            pro=1; 
        }
        pro2*=nums[n-(i+1)];
        max2=Math.max(max2,pro2);
        if(pro2==0){
            pro2=1;
        }
        }
	return Math.max(max,max2);
    }

}