class Solution {
    public List<Integer> spiralOrder(int[][] matrix){
        int left=0, right=matrix[0].length-1;
        int top=0, bottom=matrix.length-1;
        int direction=0;
        List<Integer> ans=new ArrayList<>();
        while(left<=right && top<=bottom){
            // Direction 0 – Left to Right 
            if(direction==0){
                for(int i=left;i<=right;i++){
                   ans.add(matrix[top][i]);
                }
                top++;
            }
            // Direction 1 — Top to Bottom
            if(direction==1){
                for(int i=top;i<=bottom;i++){
                    ans.add(matrix[i][right]);
                }
                right--;
            }
            // Direction 2 — Right to Left
            if(direction==2){
                for(int i=right;i>=left;i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // Direction 3 — Bottom to Top
            if(direction==3){
                for(int i=bottom;i>=top;i--){
                    ans.add(matrix[i][left]);
                }
                left++;
            }
            // Direction updates
            direction=(direction+1)%4;
        }
        return ans;
    }

}