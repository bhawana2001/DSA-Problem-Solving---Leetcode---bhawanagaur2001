class Solution {
    public void rotate(int[][] matrix){
        for(int row=0;row<matrix.length;row++){
            for(int col=row;col<matrix[0].length;col++){
                int temp=matrix[row][col];
                matrix[row][col]=matrix[col][row];
                matrix[col][row]=temp;
            }
        }
        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[0].length/2;col++){
                int temp=matrix[row][col];
                matrix[row][col]=matrix[row][matrix.length-(col+1)];
                matrix[row][matrix.length-(col+1)]=temp;
            }
        }
    }
}

