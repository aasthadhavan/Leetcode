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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        List<TreeNode> trav=new ArrayList<>();
        trav.add(root);
        while(!trav.isEmpty()){
             List<Integer> resl=new ArrayList<>();
             List<TreeNode> ntrav=new ArrayList<>();
            for(TreeNode n:trav){
                resl.add(n.val);
                if(n.left!=null){
                    ntrav.add(n.left);
                }
                if(n.right!=null){
                    ntrav.add(n.right);
                }
            }
            res.add(resl);
            trav=ntrav;
        }
        return res;
    }
}
