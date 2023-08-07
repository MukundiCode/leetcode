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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> lst = new ArrayList<Integer>();
        doInOrder(root, lst);
        return lst.get(k-1);
    }

    public static void doInOrder(TreeNode node, List<Integer> lst){
        if (node == null) return;
        doInOrder(node.left, lst);
        lst.add(node.val);
        doInOrder(node.right, lst);
    }
}