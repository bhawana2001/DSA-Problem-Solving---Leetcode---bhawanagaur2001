class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        if(n==1 && nums[0]!=target){
            return -1;
        }else if(n==1 && nums[0]==target){
        return 0;
        }
        int p=peak(nums);
        if(p==-1){
            return binarySearch(nums,0,n-1,target);
        }
        int ans1=-1;
        int ans2=-1;
        ans1=binarySearch(nums,0,p-1,target);
        ans2=binarySearch(nums,p,n-1,target);
        if(ans1==-1 && ans2==-1){
            return -1;
        }else if(ans1==-1){
            return ans2;
        }else{
            return ans1;
        }
    }
    public int binarySearch(int[] nums,int i,int j,int target){
        while(i<=j){
            int mid=i+(j-i)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return -1;
    }
    public int peak(int[] nums){
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