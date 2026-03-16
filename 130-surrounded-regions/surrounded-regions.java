class Solution {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    public void dfs(char[][] board,int i,int j,int m,int n,boolean[][] visited){
        for(int k=0;k<4;k++){
            int nx = dx[k]+i;
            int ny = dy[k]+j;
            if(nx>=0 && ny>=0 && nx<m && ny<n && visited[nx][ny]==false && board[nx][ny]=='O'){
                visited[nx][ny]=true;
                dfs(board,nx,ny,m,n,visited);
            }
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || j==0 || j==n-1 || i==m-1) && board[i][j]=='O'){
                    visited[i][j]=true;
                    dfs(board,i,j,m,n,visited);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==false && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }

    }
}