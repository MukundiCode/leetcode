class Solution {
    //Kadane's algorithm
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int current = 0;

        for (int i = 0; i < nums.length; i++){
            current = (current + nums[i] > nums[i]) ? (current + nums[i]) : nums[i];
            max = (current > max) ? current : max;
        }
       return max;       
    }
}