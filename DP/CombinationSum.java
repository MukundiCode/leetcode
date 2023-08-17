class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < candidates.length; i++){
            getSum(candidates, target, i, ans, new ArrayList<Integer>(), 0);
        }

        return ans;
    }

    public static void getSum(int[] candidates, int target, int index, List<List<Integer>> ans, List<Integer> currentArray, int sum){
        if (index >= candidates.length) return;

        currentArray.add(candidates[index]);

        sum += candidates[index];

        if (sum > target) return;

        if (sum == target) {
            ans.add(currentArray);
        }

        for (int i = index; i < candidates.length; i++){
            getSum(candidates, target, i, ans, new ArrayList<>(currentArray), sum);
        }

    }

    
}