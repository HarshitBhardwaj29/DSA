class Pair {
    int n;
    int w;
    Pair(int n, int w) {
        this.n = n;
        this.w = w;
    }
}
class Solution {
    public int minCost(int n, int[][] edges) {
        ArrayList<ArrayList<Pair>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            list.get(u).add(new Pair(v, w));
            list.get(v).add(new Pair(u, 2 * w));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new Pair(0, 0));
        dist[0] = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (p.w > dist[p.n]) continue;
            if (p.n == n - 1) return p.w;
            for (Pair q : list.get(p.n)) {
                if (p.w + q.w < dist[q.n]) {
                    dist[q.n] = p.w + q.w;
                    pq.add(new Pair(q.n, dist[q.n]));
                }
            }
        }
        return -1;
    }
}
