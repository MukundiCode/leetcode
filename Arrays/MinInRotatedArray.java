import java.util.*;
class Solution {
    public int findMin(int[] nums) {
        // case one: no rotations
        if (nums[0] < nums[nums.length - 1] || nums.length == 1) return nums[0];

        if (nums.length < 4) {
            Arrays.sort(nums);
            return nums[0];
        }
        // case two: has rotations
        int ans = binary(nums, 0, nums.length - 1);

        return ans;

    }

    public static int binary(int[] nums,int left,int right){
        // stopping condition
        int mid = left + (right - left) / 2;
        if (right - left == 1){
            return (nums[left] < nums[right]) ? nums[left] : nums[right];
        }
        if (nums[left] < nums[right]){
            return nums[left];
        }
        if (nums[mid] < nums[mid - 1]){
            return nums[mid];
        }
        if (nums[left] < nums[mid]){
            return binary(nums, mid + 1, right);
        }
        return binary(nums, left, mid - 1);
    }
}