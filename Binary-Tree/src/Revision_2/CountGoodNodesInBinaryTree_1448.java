import java.util.*;
public class CountGoodNodesInBinaryTree_1448{
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
    public static int countGoodNodes(TreeNode root,int max){
        if(root==null) return 0;
        max=Math.max(root.val,max);
        int leftCnt=countGoodNodes(root.left,max);
        int rightCnt=countGoodNodes(root.right,max);
        if(max>root.val){
            return leftCnt+rightCnt;
        }else {
            return leftCnt+rightCnt+1;
        }
    }
    public static void main(String[] args){
        //Integer[] nums={3,1,3,null,null,null,4,1,null,null,5,null,null};
        //Integer[] nums={3,3,4,null,null,2,null,null,null};
        //Integer[] nums={1,null,null};
        Integer[] nums={};
        TreeNode root=buildTree(nums);
        System.out.println("Count >> "+countGoodNodes(root,Integer.MIN_VALUE));
    }
}
