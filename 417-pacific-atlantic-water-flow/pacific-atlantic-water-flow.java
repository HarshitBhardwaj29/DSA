import java.util.*;

class Solution {

    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};

    public void dfs(int[][] heights,int i,int j,boolean[][] visited){
        int m = heights.length;
        int n = heights[0].length;
        visited[i][j] = true;
        for(int k=0;k<4;k++){
            int ni = i + dx[k];
            int nj = j + dy[k];
            if(ni>=0 && nj>=0 && ni<m && nj<n &&!visited[ni][nj] &&heights[ni][nj] >= heights[i][j]){
                dfs(heights,ni,nj,visited);
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            dfs(heights,0,i,pacific);
        }
        for(int i=0;i<m;i++){
            dfs(heights,i,0,pacific);
        }
        for(int i=0;i<n;i++){
            dfs(heights,m-1,i,atlantic);
        }
        for(int i=0;i<m;i++){
            dfs(heights,i,n-1,atlantic);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }
}