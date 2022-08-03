public class ClosestBinarySearchTreeValue_270{
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
    public static void display(TreeNode root){
        if(root==null) return;
        StringBuilder sb=new StringBuilder();
        sb.append(root.left==null ? "-"  :root.left.val);
        sb.append(" < "+root.val+" > ");
        sb.append(root.right==null ? "-" :root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }
    public static int closestValue(TreeNode root,double target) {
        int val=0;
        int closestVal=0;
        while(root!=null){
            val=root.val;
            closestVal=Math.abs(target-root.val) < Math.abs(closestVal-root.val) ? root.val : closestVal;
            root=target < root.val ? root.right : root.left;
        }
        return closestVal;
    }
    public static void main(String[] args){
        Integer[] nums={4,2,1,null,null,3,null,null,5,null,null};
        double target=3.714286;
        TreeNode root=buildTree(nums);
        //display(root);
        System.out.println(closestValue(root,target));
    }
}
