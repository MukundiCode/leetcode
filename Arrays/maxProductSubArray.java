//can use kadane's algo twice, back and forth
class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++){
            int start = 1;
            for(int z = i; z < nums.length; z++){
                start *= nums[z];
                max = (start > max) ? (start) : max;
            }
        }
        return max;
        
    }
}