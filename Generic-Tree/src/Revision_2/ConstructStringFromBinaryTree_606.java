public class ConstructStringFromBinaryTree_606{
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
        if(nums[idx]==null){
            idx++;
            return null;
        }
        TreeNode root=new TreeNode(nums[idx++]);
        root.left=buildTree(nums);
        root.right=buildTree(nums);
        return root;
    }
    //static StringBuilder sb=new StringBuilder();
    public static StringBuilder tree2str(TreeNode root) {
        if(root==null) return new StringBuilder("()");
        if(root.left==null && root.right==null) {
            //leaf node
            return new StringBuilder("("+root.val+")");
        }
        StringBuilder left=tree2str(root.left);
        StringBuilder right=tree2str(root.right);
        StringBuilder sb=new StringBuilder();
        System.out.println("Left >>"+left);
        System.out.println("Right >>"+right);
        if(right.length()==2){
            sb.append("("+root.val+left+")");
        }else{
            sb.append("("+root.val+left+right+")");
        }
        System.out.println("result >> "+sb.toString());
        return sb;
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

    public static void main(String[] args){
        Integer[] nums={1,2,null,4,null,null,3,null};
        //Integer[] nums={1,2,4,null,null,null,3,null,null};
        TreeNode root=buildTree(nums);
        display(root);
        StringBuilder sb=tree2str(root);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
        System.out.println("Constructed String >>"+sb);
    }
}
