/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Basically find ancestors of p then q then find common 
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pAncestors = new ArrayList<>();
        List<TreeNode> qAncestors = new ArrayList<>();
        List<TreeNode> common = new ArrayList<>();
        findAncestors(root, p, pAncestors);
        findAncestors(root, q, qAncestors);

        TreeNode lowest = new TreeNode(Integer.MAX_VALUE);
        for (TreeNode pNode : pAncestors){
            for (TreeNode qNode : qAncestors){
                if (pNode == qNode) {
                    common.add(pNode);
                }
            }
        }
        return common.get(common.size()-1);
    }

    public static void findAncestors(TreeNode root, TreeNode target, List<TreeNode> ancestors ){
        ancestors.add(root);
        if (root == target){
            return;
        }

        if (root.val > target.val){
            findAncestors(root.left, target, ancestors);
        } else {
            findAncestors(root.right, target, ancestors);
        }

    }
}