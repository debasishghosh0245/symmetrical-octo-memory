public class SumOfLeftLeaves_404{
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
    public static TreeNode buildTree(Integer[] nums){
        if(idx==nums.length) return null;
        if(nums[idx]==null) {
            idx++;
            return null;
        }
        TreeNode root=new TreeNode(nums[idx++]);
        root.left=buildTree(nums);
        root.right=buildTree(nums);
        return root;
    }
    static int sum=0;
    public static void sumOfLeftLeaves(TreeNode root) {
        if(root==null) return;
        if(root.left!=null && root.left.left==null && root.left.right==null){
            System.out.println("leaf "+ root.left.val);
            sum+=root.left.val;
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
    }
    public static void display(TreeNode root){
        if(root==null) return;
        StringBuilder sb=new StringBuilder();
        sb.append(root.left==null  ? "-" :root.left.val);
        sb.append(" < "+root.val+" > ");
        sb.append(root.right==null ? "-" :root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }
    public static void main(String[] args){
        //Integer[] nums={3,9,null,null,20,15,null,null,7,null,null};
        Integer[] nums={-9,-3,null,4,-6,null,null,null,2,4,-5,null,null,null,0,null,null};
        TreeNode root=buildTree(nums);
        display(root);
        sumOfLeftLeaves(root);
        System.out.println("Sum >>"+sum);
    }
}
