class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge=mergeArray(nums1,nums2,nums1.length,nums2.length);
        int n=merge.length;
        double ans=0.0;
        if(n%2==0){
            int ele1=merge[n/2];
            int ele2=merge[n/2-1];
            ans=(double)(ele1+ele2)/2;
        }else if(n%2!=0){
         ans=merge[n/2];
        }
        return ans;
    }
    public int[] mergeArray(int[] a,int[] b,int m,int n){
        int[] merge=new int[m+n];
        int i=0;
        int j=0;
        int k=0;
        while(i<m && j<n){
            if(a[i]<b[j]){
                merge[k]=a[i];
                i++;
            }else{
                merge[k]=b[j];
                j++;
            }
            k++;
        }
        while(i<m){
            merge[k++]=a[i++];
        }
        while(j<n){
            merge[k++]=b[j++];
        }
        return merge;
    }
}