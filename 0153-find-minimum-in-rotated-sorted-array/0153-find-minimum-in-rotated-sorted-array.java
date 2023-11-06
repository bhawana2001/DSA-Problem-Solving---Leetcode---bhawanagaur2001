class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        if(n==1){
            return nums[0];
        }
        int p=peakIndex(nums);
        System.out.println(p);
       return p==-1?nums[0]:Math.min(nums[p],nums[0]);
    }
    public int peakIndex(int[] nums){
        int n=nums.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(mid==0 && nums[mid+1]<=nums[mid]){
                return mid+1;
            }
            if(mid==n-1 && nums[mid-1]>=nums[mid]){
                return mid;
            }
            if(mid>0 && mid<n-1 && nums[mid-1]>=nums[mid] && nums[mid]<=nums[mid+1]){
                return mid;
            }
            if(nums[0]>nums[mid]){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;
    }
}