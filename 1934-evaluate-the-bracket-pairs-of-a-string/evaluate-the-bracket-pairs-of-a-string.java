class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < knowledge.size(); i++) {
            String s1 = knowledge.get(i).get(0);
            String s2 = knowledge.get(i).get(1);
            map.put(s1, s2);
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                i++;
                String ans = "";
                while (s.charAt(i) != ')') {
                    ans += s.charAt(i);
                    i++;
                }
                if (map.containsKey(ans)) {
                    sb.append(map.get(ans));
                } else {
                    sb.append("?");
                }
                i++; 
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}