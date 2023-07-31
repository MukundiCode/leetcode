import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end  = nums.length - 1;
        int[] ans = new int[2];

        for (int i = 0; i < nums.length-1;i++){
            for (int z = i+1; z < nums.length; z++){
                if (nums[i] + nums[z] == target){
                    ans[0] = i;
                    ans[1] = z;
                }
            }
        }
        return ans;
    }
}