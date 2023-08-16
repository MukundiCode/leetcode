class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[k];

        for (int n : nums){
            if (map.containsKey(n)){
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        List<Integer> list = map.entrySet().stream()
                                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                                .limit(k)
                                .map(Map.Entry::getKey)
                                .collect(Collectors.toList());

        for (int i = 0; i < k; i++){
            ans[i] = list.get(i);
        }

        return ans;
    }
}