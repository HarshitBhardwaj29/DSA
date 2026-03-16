import java.util.*;

class Solution {
    public int maxDistance(int[][] grid) {

        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    q.add(new int[]{i,j});
                }
            }
        }

        if(q.isEmpty() || q.size()==n*n) return -1;

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        int dist = -1;

        while(!q.isEmpty()){
            int size = q.size();
            dist++;
            for(int k=0;k<size;k++){
                int[] cell = q.poll();
                int x = cell[0];
                int y = cell[1];
                for(int d=0;d<4;d++){
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if(nx>=0 && ny>=0 && nx<n && ny<n && grid[nx][ny]==0){
                        grid[nx][ny] = 1;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }

        return dist;
    }
}