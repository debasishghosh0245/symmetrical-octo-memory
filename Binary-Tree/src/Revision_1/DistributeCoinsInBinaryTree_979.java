import java.util.*;
public class DistributeCoinsInBinaryTree_979{
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
    public static TreeNode buildTree(Integer[] nums){
        Queue<TreeNode> queue=new LinkedList<>();
        int idx=0;
        TreeNode root=new TreeNode(nums[idx]);
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode topNode=queue.poll();
            if(topNode==null) continue;
            if(nums[++idx]==null){
                topNode.left=null;
            }else{
                topNode.left=new TreeNode(nums[idx]);
            }
            queue.offer(topNode.left);
            if(nums[++idx]==null){
                topNode.right=null;
            }else{
                topNode.right=new TreeNode(nums[idx]);
            }
            queue.offer(topNode.right);
        }
        return root;
    }
    public static void display(TreeNode root){
        if(root==null) return;
        StringBuilder sb=new StringBuilder();
        sb.append(root.left==null ?  "-" : root.left.val);
        sb.append(" < "+root.val+" > ");
        sb.append(root.right==null ? "-" : root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }
    static int steps=0;
    public static int distributeCoins(TreeNode root){
        if(root==null) return 0;
        int left=distributeCoins(root.left);
        int right=distributeCoins(root.right);
        steps+=Math.abs(left)+Math.abs(right);
        System.out.println("left >>"+left);
        System.out.println("Right >>"+right);
        return root.val-left-right-1;
    }
    public static void main(String[] args){
        //Integer[] nums={0,3,0,null,null,null,null};
        Integer[] nums={1,0,0,null,3,null,null,null,null};
        TreeNode root=buildTree(nums);
        display(root);
        distributeCoins(root);
        System.out.println(steps);
    }
}
