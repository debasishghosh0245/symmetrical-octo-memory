public class SubtreeOfAnotherTree_572{
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
    static class WrappableInteger{
        int val;
        WrappableInteger(int val){
            this.val=val;
        }
        int getValue(){
            return this.val;
        }
        void increment(){
            this.val++;
        }
    }
    public static TreeNode buildTree(Integer[] nums,WrappableInteger idx){
        if(idx.getValue()==nums.length) return null;
        if(nums[idx.getValue()]==null){
            idx.increment();
            return null;
        }
        TreeNode root=new TreeNode(nums[idx.getValue()]);
        idx.increment();
        root.left=buildTree(nums,idx);
        root.right=buildTree(nums,idx);
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
    public static boolean isSameTree(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        if(root1.val==root2.val) return true;
        boolean left=isSameTree(root1.left,root2.left);
        boolean right=isSameTree(root1.right,root2.right);
        return left && right;
    }
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null) return false;
        if(isSameTree(root,subRoot)) return true;
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    public static void main(String[] args){
        Integer[] nums1={3,4,1,null,null,2,0,null,null,null,5,null,null};
        TreeNode root1=buildTree(nums1,new WrappableInteger(0));
        display(root1);
        System.out.println("---------------------");
        Integer[] nums2={4,1,null,null,2,null,null};
        TreeNode root2=buildTree(nums2,new WrappableInteger(0));
        display(root2);
        System.out.println(isSubtree(root1,root2));
    }
}
