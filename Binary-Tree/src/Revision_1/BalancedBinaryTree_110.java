public class BalancedBinaryTree_110{

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
    public static int idx=0;
    public static TreeNode constructBT(Integer[] nums){
        if(idx>=nums.length) return null;
        if(nums[idx]==null) {
            idx++;
            return null;
        }
        TreeNode root=new TreeNode(nums[idx++]);
        root.left=constructBT(nums);
        root.right=constructBT(nums);
        return root;
    }
    public static class Pair{
        boolean isBalanced;
        int height;
    }
    public static Pair isBalanced(TreeNode root){
        if(root==null){
            Pair pair=new Pair();
            pair.isBalanced=true;
            pair.height=-1;
            return pair;
        }
        Pair left=isBalanced(root.left);
        Pair right=isBalanced(root.right);
        Pair pair=new Pair();
        pair.height=1+Math.max(left.height,right.height);
        if(left.isBalanced && right.isBalanced){
            pair.isBalanced=Math.abs(left.height-right.height)<=1;
        }else{
            pair.isBalanced=false;
            return pair;
        }
        return pair;
    }

    public static int[] isBalanced_2(TreeNode root){
        if(root==null){
            int[] arr=new int[2];
            arr[0]=1;
            arr[1]=-1;
            return arr;
        }
        int[] left=isBalanced_2(root.left);
        int[] right=isBalanced_2(root.right);
        int[] arr=new int[2];
        arr[1]=1+Math.max(left[1],right[1]);
        if(left[0]==1 && right[0]==1){
            arr[0]=Math.abs(left[1]-right[1])<=1 ? 1 :0;
        }else{
            arr[0]=0;
            return arr;
        }
        return arr;
    }

    public static boolean isBalanced=false;
    public static int isBalanced_3(TreeNode root){
        if(root==null) return -1;
        int leftHeight=isBalanced_3(root.left);
        int rightHeight=isBalanced_3(root.right);
        isBalanced=Math.abs(leftHeight-rightHeight)<=1;
        return 1+Math.max(leftHeight,rightHeight);
    }

    public static void display(TreeNode root){
        if(root==null) return;
        StringBuilder sb=new StringBuilder();
        sb.append(root.left==null ? "-": root.left.val);
        sb.append(" < "+root.val+" > ");
        sb.append(root.right==null ? "-" :root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }
    public static void main(String[] args){
        //Integer[] nums={3,9,null,null,20,15,null,null,7,null,null};
        Integer[] nums={1,2,3,4,null,null,4,null,null,3,null,null,2,null,null};
        TreeNode root=constructBT(nums);
        display(root);
        isBalanced_3(root);
        System.out.println(isBalanced);
    }

}
