class Solution {
    class Pair {
        int node;
        double prob;
        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];
            graph.get(u).add(new Pair(v, p));
            graph.get(v).add(new Pair(u, p));
        }
        double[] dist = new double[n];
        dist[start] = 1.0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.add(new Pair(start,1.0));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.node;
            double prob = curr.prob;
            if(node==end)return prob;
            for(Pair p:graph.get(node)){
                int neigh = p.node;
                double newdis = prob*p.prob;
                if(newdis>dist[neigh]){
                    dist[neigh]=newdis;
                    pq.add(new Pair(neigh,newdis));
                }
            }
        }
        return 0.0;
    }
}