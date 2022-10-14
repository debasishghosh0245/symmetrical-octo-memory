public class BinaryTreeMaximumPathSum_124{
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
        sb.append(root.left==null ? "-" : root.left.val);
        sb.append(" < "+root.val+" > ");
        sb.append(root.right==null ? "-" : root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }
    public static class Pair{
        int rootToLeafMaxPathSum;
        int maxPathSum=Integer.MIN_VALUE;
        Pair(){
        }
        Pair(int rootToLeafMaxPathSum,int maxPathSum){
            this.rootToLeafMaxPathSum=rootToLeafMaxPathSum;
            this.maxPathSum=maxPathSum;
        }
    }
    public static Pair maxPathSum(TreeNode root){
        if(root==null){
            Pair pair=new Pair(0,Integer.MIN_VALUE);
            return pair;
        }
        Pair left=maxPathSum(root.left);
        Pair right=maxPathSum(root.right);
        int rootToLeafMaxPathSumLeft=Math.max(0,left.rootToLeafMaxPathSum);
        int rootToLeafMaxPathSumRight=Math.max(0,right.rootToLeafMaxPathSum);
        System.out.println("left >>"+rootToLeafMaxPathSumLeft);
        System.out.println("Right >>"+rootToLeafMaxPathSumRight);
        Pair pair=new Pair();
        pair.rootToLeafMaxPathSum=root.val+Math.max(rootToLeafMaxPathSumLeft,
            rootToLeafMaxPathSumRight);
            System.out.println("Curr Sum >>"+(root.val+rootToLeafMaxPathSumLeft+rootToLeafMaxPathSumRight));
            System.out.println("Max Path Sum >"+pair.maxPathSum);
        pair.maxPathSum=Math.max(root.val+rootToLeafMaxPathSumLeft+
            rootToLeafMaxPathSumRight,pair.maxPathSum);
        pair.maxPathSum=Math.max(Math.max(left.maxPathSum,right.maxPathSum),
            pair.maxPathSum);
        System.out.println("Max Path Sum >>"+pair.maxPathSum);
        return pair;
    }
    public static void main(String[] args){
        //Integer[] nums={-10,9,null,null,20,15,null,null,7,null,null};
        //Integer[] nums={-3,null,null};
        //Integer[] nums={2,-1,null,null,null};
        //Integer[] nums={1,-2,null,null,3,null,null};
        //Integer[] nums={-2,-1,null,null,null};
        TreeNode root=buildTree(nums);
        // /display(root);
        Pair pair=maxPathSum(root);
        System.out.println(pair.maxPathSum);
    }
}
