class Pair{
    char c;
    int freq;
    Pair(char c,int freq){
        this.c = c;
        this.freq = freq;
    }
}
class Solution {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.freq-a.freq);
        int[] arr = new int[256];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)]++;
        }
        for(int i=0;i<256;i++){
            if(arr[i]>0){
                pq.add(new Pair((char)i,arr[i]));
            }
        }
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int freq = p.freq;
            char c = p.c;
            for(int i=0;i<freq;i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}