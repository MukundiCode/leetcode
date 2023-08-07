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
 import java.util.*;
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.add(root);

        while(!qu.isEmpty()){
            int size = qu.size();
            List<Integer> sub = new ArrayList<>();
            for (int i = 0; i < size ; i++){
                TreeNode node = qu.poll();
                sub.add(node.val);
                if (node.left != null) qu.add(node.left);
                if (node.right != null) qu.add(node.right);
            }
            result.add(sub);
        }
        return result;
    }
}