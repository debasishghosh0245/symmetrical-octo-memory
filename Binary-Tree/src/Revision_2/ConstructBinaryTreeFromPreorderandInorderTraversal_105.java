public class ConstructBinaryTreeFromPreorderandInorderTraversal_105{
    TreeNode root;
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }
    static int preorderIdx=0;
    public static TreeNode buildBinaryTree(int[] preorder,int[] inorder,int left,int right){
        if(preorderIdx > preorder.length) return null;
        if(left>right) return null;
        TreeNode root=new TreeNode(preorder[preorderIdx]);
        int idx=0;
        while(preorder[preorderIdx]!=inorder[idx]){
            idx++;
        }
        preorderIdx++;
        root.left=buildBinaryTree(preorder,inorder,left,idx-1);
        root.right=buildBinaryTree(preorder,inorder,idx+1,right);
        return root;
    }
    public static void display(TreeNode root){
        if(root==null) return;
        StringBuilder sb=new StringBuilder();
        sb.append(root.left==null ? "-" :root.left.val);
        sb.append(" < "+root.val+" > ");
        sb.append(root.right==null ? "-" :root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }
    public static void main(String[] args){
        // int[] preorder={3,9,20,15,7};
        // int[] inorder={9,3,15,20,7};
        int[] preorder={-1};
        int[] inorder={-1};
        TreeNode root=buildBinaryTree(preorder,inorder,0,inorder.length-1);
        display(root);
    }
}
