public class ConstructBinarySearchTreeFromPostTraversal_1008 {
    public static void main(String[] args){
        int[] postorder={1,7,5,12,10,8};
        idx=postorder.length-1;
        TreeNode root=buildTree(postorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
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
    public static TreeNode buildTree(int[] postorder,int min,int max){
        if(idx<0) return null;
        if(postorder[idx] < min || postorder[idx] > max) return null;
        int val=postorder[idx--];
        TreeNode root=new TreeNode(val);
        root.right=buildTree(postorder,val,max);
        root.left=buildTree(postorder,min,val);
        return root;
    }
    public static void display(TreeNode root){
        if(root==null) return;
        StringBuilder sb=new StringBuilder();
        sb.append(root.left==null ? "-" : root.left.val);
        sb.append(" < "+root.val+" > ");
        sb.append(root.right==null ? "-" :root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }
}
