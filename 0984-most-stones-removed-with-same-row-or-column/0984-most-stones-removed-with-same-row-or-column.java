class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        if (n == 1) return 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (stones[i][0] != -1) {
                res++;
                dfs(stones, i);
            }
        }
        return n - res;
    }
    
    public void dfs(int[][] stones, int i) {
        int x = stones[i][0];
        int y = stones[i][1];
        stones[i][0] = -1; 
        
        for (int j = 0; j < stones.length; j++) {
            if (stones[j][0] != -1 && (stones[j][0] == x || stones[j][1] == y)) {
                dfs(stones, j);
            }
        }
    }
}
