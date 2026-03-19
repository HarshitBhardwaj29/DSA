class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for(int i = 0; i < tasks.length; i++){
            arr[tasks[i] - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > 0) pq.add(arr[i]);
        }
        int time = 0;
        while(!pq.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int cycle = n+1;
            while(cycle>0 && !pq.isEmpty()){
                int p = pq.poll();
                p= p-1;
                if(p>0){
                    list.add(p);
                }
                cycle--;
                time++;
            }
            for(int i:list){
                pq.add(i);
            }
            if(!pq.isEmpty()){
                time += cycle;
            }
        }
        return time;
    }
}