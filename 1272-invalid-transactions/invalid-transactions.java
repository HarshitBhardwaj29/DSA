class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;
        Set<Integer> invalid = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String[] p1 = transactions[i].split(",");
            String name1 = p1[0];
            int time1 = Integer.parseInt(p1[1]);
            int amount1 = Integer.parseInt(p1[2]);
            String city1 = p1[3];

            if (amount1 > 1000) {
                invalid.add(i);
            }

            for (int j = i + 1; j < n; j++) {
                String[] p2 = transactions[j].split(",");
                String name2 = p2[0];
                int time2 = Integer.parseInt(p2[1]);
                int amount2 = Integer.parseInt(p2[2]);
                String city2 = p2[3];

                if (name1.equals(name2) &&
                    Math.abs(time1 - time2) <= 60 &&
                    !city1.equals(city2)) {

                    invalid.add(i);
                    invalid.add(j);
                }
            }
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (invalid.contains(i)) {
                ans.add(transactions[i]);
            }
        }

        return ans;
    }
}

