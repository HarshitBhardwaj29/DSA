class Solution {
    public int removeStones(int[][] stones) {
        HashMap<Integer,ArrayList<Integer>>map=new HashMap<>();
        for(int i=0;i<stones.length;i++){
            map.put(i,new ArrayList<>());
        }
        int n=stones.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0]==stones[j][0]){
                    map.get(i).add(j);
                    map.get(j).add(i);
                }
                if(stones[i][1]==stones[j][1]){
                    map.get(i).add(j);
                    map.get(j).add(i);
                }
            }
        }
        int comp=0;
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,map,vis);
                comp++;
            }
        }  
    return n-comp;
    }
    public static void dfs(int i,HashMap<Integer,ArrayList<Integer>>map,boolean []vis){
        vis[i]=true;
        for(int x:map.get(i)){
            if(!vis[x]){
                dfs(x,map,vis);
            }
        }
    }
    
}