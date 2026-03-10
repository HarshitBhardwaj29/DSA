class Solution {
    public static void dfs(int[][] image,int sr,int sc,int color,boolean[][]visited,int m ,int n,int or){
        if(sr>=m || sc>=n || sr<0 || sc<0 ||image[sr][sc]!=or || visited[sr][sc]){
            return;
        }
        visited[sr][sc] = true;
        image[sr][sc] = color;
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, -1, 0, 1};
        for(int i=0;i<4;i++){
            dfs(image,sr+dr[i],sc+dc[i],color,visited,m,n,or);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        int or = image[sr][sc];
        if(image[sr][sc]==color)return image;
        else{
            dfs(image,sr,sc,color,visited,m,n,or);
        }
        return image;
    }
}