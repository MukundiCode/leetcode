/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 * Also check web solutions. Can in single pass use max and min values recursively
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        getInOrder(root, nums);
        for (int i = 0; i < nums.size() - 1; i++){
            if (nums.get(i) >= nums.get(i+1)) return false;
        }
        return true;

    }

    public static void getInOrder(TreeNode node, List<Integer> nums){
        if (node == null) return;

        getInOrder(node.left, nums);
        nums.add(node.val);
        getInOrder(node.right, nums);
    }
}