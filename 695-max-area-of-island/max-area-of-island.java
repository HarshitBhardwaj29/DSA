class Solution {

    public int dfs(int[][] grid,int i,int j,int m ,int n,int[][] visited){
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        visited[i][j] = 1;
        int area = 1;
        for(int k=0;k<4;k++){
            int dxi = i + dx[k];
            int dyj = j + dy[k];
            if(dxi>=0 && dyj>=0 && dxi<m && dyj<n &&
               grid[dxi][dyj]==1 && visited[dxi][dyj]==0){
                area += dfs(grid,dxi,dyj,m,n,visited);
            }
        }
        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] visited = new int[m][n];

        int max = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(grid[i][j]==1 && visited[i][j]==0){
                    max = Math.max(max,dfs(grid,i,j,m,n,visited));
                }

            }
        }

        return max;
    }
}