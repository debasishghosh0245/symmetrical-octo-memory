public class ConstructBinaryTreeFromInorderAndPostorderTraversal_106{
    TreeNode root;
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
    static int postorderIdx=0;
    public static TreeNode buildTree(int[] postorder,int[] inorder,int left,int right){
        if(left > right) return null;
        TreeNode root=new TreeNode(postorder[postorderIdx]);
        int idx=0;
        while(postorder[postorderIdx]!=inorder[idx]){
            idx++;
        }
        postorderIdx--;
        root.right=buildTree(postorder,inorder,idx+1,right);
        root.left=buildTree(postorder,inorder,left,idx-1);
        return root;
    }
    public static void display(TreeNode root){
        if(root==null) return ;
        StringBuilder sb=new StringBuilder();
        sb.append(root.left==null ? "_" : root.left.val);
        sb.append(" < "+root.val+" > ");
        sb.append(root.right==null ? "-" : root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }
    public static void main(String[] args){
        int[] inorder={9,3,15,20,7};
        int[] postorder={9,15,7,20,3};
        postorderIdx=inorder.length-1;
        TreeNode root=buildTree(postorder,inorder,0,postorder.length-1);
        display(root);
    }
}
