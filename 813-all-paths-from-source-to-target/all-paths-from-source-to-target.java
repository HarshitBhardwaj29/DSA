class Solution {
    public void dfs(int[][] graph,List<List<Integer>> list , List<Integer> ans,int node,int target){
        if(node==target){
            list.add(new ArrayList<>(ans));
            return;
        }
        for(int i=0;i<graph[node].length;i++){
            int n = graph[node][i];
            ans.add(n);
            dfs(graph,list,ans,n,target);
            ans.remove(ans.size()-1);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans  = new ArrayList<>();
        ans.add(0);
        dfs(graph,list,ans,0,n-1);
        return list;
    }
}