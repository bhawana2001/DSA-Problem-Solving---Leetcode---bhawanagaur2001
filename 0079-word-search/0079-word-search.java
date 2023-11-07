class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char ch=board[i][j];
                if(ch==word.charAt(0)){
                    if(helper(board,i,j,word,0,vis)==true){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean helper(char[][] board,int i,int j,String word,int ind,boolean[][] vis){
         if(ind>=word.length()){
            return true;
        }
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || vis[i][j]==true || board[i][j]!=word.charAt(ind)){
            return false;
        }
        int[] dirx={-1,1,0,0};
        int[] diry={0,0,1,-1};
        vis[i][j]=true;
        for(int k=0;k<4;k++){
            boolean ans=helper(board,i+dirx[k],j+diry[k],word,ind+1,vis);
            if(ans==true) return true;
        }
        vis[i][j]=false;
        return false;
    }
}