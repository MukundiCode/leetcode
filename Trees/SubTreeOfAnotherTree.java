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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> qu = new LinkedList<>();

        qu.add(root);
        while(!qu.isEmpty()){
            TreeNode next = qu.remove();
            if (next.left != null) qu.add(next.left);
            if (next.right != null) qu.add(next.right);

            if (next.val == subRoot.val){
                boolean isSubTree = compare(next, subRoot);
                if (isSubTree) {
                    return true;
                }
            }
        }
        return false;       
    }

    public static boolean compare(TreeNode root, TreeNode sub){
        if (root == null && sub == null){
            return true;
        }
        else if ((root == null && sub != null) || (root!=null && sub == null)){
            return false;
        }

        if (root.val == sub.val){
            boolean left = compare(root.left, sub.left);
            boolean right = compare(root.right, sub.right);
            return true && left && right;
        } else {
            return false;
        }
    }
}