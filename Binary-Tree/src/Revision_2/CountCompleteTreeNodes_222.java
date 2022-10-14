public class CountCompleteTreeNodes_222 {
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
    public static TreeNode buildTreeNode(Integer[] nums){
        if(idx > nums.length) return null;
        if(nums[idx]==null){
            idx++;
            return null;
        }
        TreeNode root=new TreeNode(nums[idx++]);
        root.left=buildTreeNode(nums);
        root.right=buildTreeNode(nums);
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
    public static int leftLevel(TreeNode root){
        if(root==null) return 1;
        return 1+leftLevel(root.left);
    }
    public static int rightLevel(TreeNode root){
        if(root==null) return 1;
        return 1+rightLevel(root.right);
    }
    public static int countCompleteTreeNode(TreeNode root){
        if(root==null) return 0;
        int total=0;
        int leftLevel=leftLevel(root.left);
        int rightLevel=rightLevel(root.right);
        System.out.println("Root >>"+root.val);
        System.out.println("Left >>"+leftLevel);
        System.out.println("Right >>"+rightLevel);
        if(leftLevel==rightLevel){
            System.out.println("Total 1 >> "+((int)Math.pow(2,leftLevel)-1));
            return (int)Math.pow(2,leftLevel)-1;
        }else{
            return 1+countCompleteTreeNode(root.left)+
                countCompleteTreeNode(root.right);
        }
    }
    public static void main(String[] args){
        Integer[] nums={1,2,4,8,null,null,9,null,null,5,10,null,null,11,null,null,3,6,null,null,7,null,null};
        TreeNode root=buildTreeNode(nums);
        display(root);
        System.out.println("Total >>"+countCompleteTreeNode(root));
    }
}
