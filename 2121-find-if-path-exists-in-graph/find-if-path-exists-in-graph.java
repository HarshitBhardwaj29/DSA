class Solution {
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean[] visited,int des,int node){
        if(node==des)return true;
        visited[node]=true;
        for(int i:adj.get(node)){
            if(!visited[i]){
                if(dfs(adj,visited,des,i)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        return dfs(adj,visited,destination,source);
    }
}