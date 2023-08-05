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
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return compare(p, q);
    }

    public static boolean compare(TreeNode p, TreeNode q){
        if (p == null && q == null){
            return true;
        }
        if (p == null && q != null) {
            return false;
        }
        if (p != null && q == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }
        return true && compare(p.left, q.left) && compare(p.right, q.right);
    }
}