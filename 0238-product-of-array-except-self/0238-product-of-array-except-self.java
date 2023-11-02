class Solution {
    public int[] productExceptSelf(int[] nums) {
      int[] ps=new int[nums.length];
      int[] sp=new int[nums.length];
      int[] res=new int[nums.length];
      for(int i=0;i<nums.length;i++){
          if(i==0){
              ps[i]=1;
          }else{
          ps[i]=ps[i-1]*nums[i-1];
          }
      }
      for(int i=nums.length-1;i>=0;i--){
          if(i==nums.length-1){
              sp[i]=1;
          }else{
          sp[i]=sp[i+1]*nums[i+1];
          }
      }
      for(int i=0;i<nums.length;i++){
          res[i]=ps[i]*sp[i];
      }
      return res;
    }
}