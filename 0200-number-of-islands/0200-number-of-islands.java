class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        if(n==0) return 0;
        int m=grid[0].length;
        int noOfIsland=0;
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(grid[row][col]=='1'){
                markIsland(grid,row,col,n,m);
                noOfIsland++;
                }
            }
        }
        return noOfIsland;
    }
    public void markIsland(char[][] grid,int row,int col,int n,int m){
        if(row<0 || row>=n || col<0 || col>=m || grid[row][col]!='1') return;
        grid[row][col]='2';
        markIsland(grid,row-1,col,n,m);
        markIsland(grid,row,col+1,n,m);
        markIsland(grid,row+1,col,n,m);
        markIsland(grid,row,col-1,n,m);
    }
}