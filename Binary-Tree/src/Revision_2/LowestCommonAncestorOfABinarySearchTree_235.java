public class LowestCommonAncestorOfABinarySearchTree_235{
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
        public String toString(){
            return this.val+"";
        }
    }
    static int idx=0;
    public static TreeNode buildTree(Integer[] nums){
        if(idx > nums.length) return null;
        if(nums[idx]==null) {
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
        sb.append(root.left==null ? "-" : root.left.val);
        sb.append(" < "+root.val+" > ");
        sb.append(root.right==null ? "-" : root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root,int p,int q){
        if(root==null) return null;
        System.out.println("root >>"+root.val);
        if(p < root.val && q < root.val) {
            return lowestCommonAncestor(root.left,p,q);
        }
        else if(p > root.val && q > root.val) {
            return lowestCommonAncestor(root.right,p,q);
        }
        else return root;
    }
    public static void main(String[] args){
        Integer[] nums={6,2,0,null,null,4,3,null,null,5,null,null,8,7,null,null,9,null,null};
        TreeNode root=buildTree(nums);
        display(root);
        System.out.println(lowestCommonAncestor(root,2,8));
    }
}
