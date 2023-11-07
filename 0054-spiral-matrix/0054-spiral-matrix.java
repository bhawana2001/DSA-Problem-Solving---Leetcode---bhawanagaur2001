class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        int top=0,down=matrix.length-1;
        int left=0,right=matrix[0].length-1;
        int dir=0;
    
        while(top<=down && left<=right){
            // dir=0 means left to right
            if(dir==0){
               for(int i=left;i<=right;i++){
                   res.add(matrix[top][i]);
               }
            top++;
            }
            // dir=1 means top to bottom
            else if(dir==1){
                for(int i=top;i<=down;i++){
                    res.add(matrix[i][right]);
            }
            right--;
            }
            // dir=2 means right to left
           else if(dir==2){
                for(int i=right;i>=left;i--){
                    res.add(matrix[down][i]);
            }
            down--;
           }
            // dir=3 means down to top
            else if(dir==3){
                for(int i=down;i>=top;i--){
                    res.add(matrix[i][left]);
            }
            left++;
            }
            
            //update direction
            dir=(dir+1)%4;
        }
        return res;
    }
}