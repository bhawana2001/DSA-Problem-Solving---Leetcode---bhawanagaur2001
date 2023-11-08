class Solution {
    public boolean exist(char[][] board,String word){
        int m=board.length;
        int n=board[0].length;
        boolean[][] visited=new boolean[m][n];
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                char  ch=board[row][col];
                if(ch==word.charAt(0)){
                    boolean ans=helper(board,word,row,col,0,visited);
                    if(ans==true){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board,String word,int row,int col,int ind,boolean[][] visited){
        if(ind>=word.length()){
            return true;
        }
        if(row<0 || row>=board.length || col<0 || col>=board[0].length || board[row][col]!=word.charAt  (ind) || visited[row][col]==true){
            return false;
        }
        int[] dirx={-1,1,0,0};
        int[] diry={0,0,1,-1};
        visited[row][col]=true;
        for(int i=0;i<4;i++){
        boolean ans=helper(board,word,row+dirx[i],col+diry[i],ind+1,visited);
        if(ans==true){
                return true;
            }
        }
        visited[row][col]=false;
        return false;
    }

}