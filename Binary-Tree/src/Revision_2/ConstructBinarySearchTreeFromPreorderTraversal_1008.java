public class ConstructBinarySearchTreeFromPreorderTraversal_1008{
    public static void main(String[] args){
        int[] preorder={8,5,1,7,10,12};
        TreeNode root=buildTree(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
        display(root);
    }
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
    static int idx=0;
    public static TreeNode buildTree(int[] preorder,int min,int max){
        if(idx>=preorder.length) return null;
        if(preorder[idx] < min || preorder[idx] > max) {
            return null;
        }
        int val=preorder[idx++];
        TreeNode root=new TreeNode(val);
        root.left=buildTree(preorder,min,val);
        root.right=buildTree(preorder,val,max);
        return root;
    }
    public static void display(TreeNode root){
        if(root==null) return;
        StringBuilder sb=new StringBuilder();
        sb.append(root.left==null ? "-" : root.left.val);
        sb.append(" < "+root.val+" > ");
        sb.append(root.right==null ? "-" : root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }
}
