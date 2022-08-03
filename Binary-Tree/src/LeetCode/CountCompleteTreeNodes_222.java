public class CountCompleteTreeNodes_222{
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
    public static TreeNode buildTree(Integer[ ] nums){
        if(idx==nums.length) return null;
        if(nums[idx]==null){
            idx++;
            return null;
        }
        TreeNode root=new TreeNode(nums[idx++]);
        root.left=buildTree(nums);
        root.right=buildTree(nums);
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
    public static int leftDepth(TreeNode root){
        if(root==null) return 0;
        return 1+leftDepth(root.left);
    }
    public static int rightDepth(TreeNode root){
        if(root==null) return 0;
        return 1+rightDepth(root.right);
    }
    public static int countTreeNode(TreeNode root){
        if(root==null) return 0;
        int leftHeight=leftDepth(root.left);
        int rightHeight=rightDepth(root.right);
        if(leftHeight==rightHeight){
            return ((2<<leftHeight)-1);
        }else{
            return 1+countTreeNode(root.left)+countTreeNode(root.right);
        }
    }
    public static void main(String[] args){
        Integer[] nums={1,2,4,null,null,5,null,null,3,6,null,null,null};
        TreeNode root=buildTree(nums);
        display(root);
        System.out.println("TreeNodes >> "+countTreeNode(root));
    }
}
