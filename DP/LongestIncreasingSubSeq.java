class Solution {
    public int lengthOfLIS(int[] nums) {

        int max = 0;
        int[] memo = new int[nums.length];

        for (int i = 0; i < nums.length; i++ ){
            int m = getLis(nums, i, Integer.MIN_VALUE, memo);
            max = (m > max) ? m : max;
        }

        return max;
    }

    static int getLis(int[] nums, int index, int prev, int[] memo){
        if (index == nums.length){
            return 0;
        }

        if (nums[index] <= prev){
            return 0;
        }

        if (memo[index] > 0){
            return memo[index];
        }

        int max = 0;
        for (int i = index + 1; i < nums.length; i++){
            int m = getLis(nums, i, nums[index], memo);
            max = (m > max) ? m : max;
        }

        memo[index] = 1 + max;
        return 1 + max;
    }
    
}