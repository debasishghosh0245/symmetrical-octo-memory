public class MergeTwoBinaryTrees_617{
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
    public static class WrappableInt{
        private Integer value;
        WrappableInt(int val){
            this.value=val;
        }
        public int getValue(){
            return value;
        }
        public void increment(){
            value++;
        }
    }
    public static TreeNode buildTree(Integer[] nums,WrappableInt idx){
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
        sb.append(root.left==null ? "-":root.left.val);
        sb.append(" < "+root.val+" > ");
        sb.append(root.right==null ? "-":root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }

    public static TreeNode merge(TreeNode root1,TreeNode root2){
        if(root1==null) return root2;
        if(root2==null) return root1;
        TreeNode root=new TreeNode(root1.val+root2.val);
        root.left=merge(root1.left,root2.left);
        root.right=merge(root1.right,root2.right);
        return root;
    }

    public static void main(String[] args){
        Integer[] nums1={1,3,5,null,null,null,2,null,null};
        TreeNode root1=buildTree(nums1,new WrappableInt(0));
        display(root1);
        System.out.println("===========================");
        Integer[] nums2={2,1,null,4,null,null,3,null,7,null,null};
        TreeNode root2=buildTree(nums2,new WrappableInt(0));
        display(root2);
        System.out.println("Merge >>----------");
        TreeNode root=merge(root1,root2);
        display(root);
    }
}
