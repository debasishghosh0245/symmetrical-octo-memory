public class ConstructBstFromInorderTraversal{
    public static void main(String[] args){
        int[] inorder={1,2,3,4,5,6,7};
        TreeNode root=buildTree(inorder,0,inorder.length-1);
        display(root);
    }
    public TreeNode root;
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
    public static TreeNode buildTree(int[] inorder,int left,int right){
        if(left > right) return null;
        int mid=(left+right)/2;
        TreeNode root=new TreeNode(inorder[mid]);
        root.left=buildTree(inorder,left,mid-1);
        root.right=buildTree(inorder,mid+1,right);
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
