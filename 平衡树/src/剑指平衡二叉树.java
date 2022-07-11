
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=dfs(root.left);
        int r=dfs(root.right);
        if(l==-1||r==-1||Math.abs(l-r)>1){
            return -1;
        }
        return Math.max(l,r)+1;
    }
    public boolean isBalanced(TreeNode root) {
        return dfs(root)>=0;
    }
}

public class 剑指平衡二叉树 {
    public static void main(String[] args) {

    }
}
