class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;

        for (int x = 0; x < grid.length; x++){
            for (int y = 0; y <grid[0].length; y++){
                if (isIsland(x, y, grid)){
                    ans ++;
                }
            }
        }
        return ans;
    }

    public static boolean isIsland(int x, int y, char[][] grid){
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return false;
        if (grid[x][y] == '0' || grid[x][y] == '2') return false;

        grid[x][y] = '2';
        boolean ans = true | isIsland(x+1, y, grid) | isIsland(x-1, y, grid) | isIsland(x, y+1, grid) | isIsland(x, y-1, grid);
        return ans;
    }
}