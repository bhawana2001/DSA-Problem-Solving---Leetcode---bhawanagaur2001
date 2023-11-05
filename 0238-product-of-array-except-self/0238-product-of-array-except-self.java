class Solution {
    public int[] productExceptSelf(int[] nums){
        int n=nums.length;
        int[] preProduct=new int[n];
        int[] postProduct=new int[n];
        int[] result=new int[n];
        int pre=1;
        int post=1;
        // fill pre product array
        for(int i=0;i<n;i++){
            
            if(i==0){
                preProduct[i]=pre;
               }else{
           pre*=nums[i-1];
           preProduct[i]=pre;
               }
        }
        // fill post product array
        for(int i=n-1;i>=0;i--){
            if(i==n-1){
                postProduct[i]=1;
            }else{
            post*=nums[i+1];
            postProduct[i]=post;
            }
        }
        //compute result array
        for(int i=0;i<n;i++){
        result[i]=preProduct[i]*postProduct[i];
        }
        return result;
    }

}