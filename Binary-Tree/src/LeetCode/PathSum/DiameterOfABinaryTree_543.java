import java.util.*;
public class DiameterOfABinaryTree_543{
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
        sb.append(" "+root.val+" ");
        sb.append(root.right==null ? "-" : root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }
    public static class Pair{
        int diameter;
        int height;
        Pair(){
        }
        Pair(int diameter,int height){
            this.diameter=diameter;
            this.height=height;
        }
    }
    public static Pair diameter(TreeNode root){
        if(root==null){
            Pair pair=new Pair(Integer.MIN_VALUE,-1);
            return pair;
        }
        Pair left=diameter(root.left);
        Pair right=diameter(root.right);
        Pair pair=new Pair();
        pair.height=1+Math.max(left.height,right.height);
        int currDiameter=2+left.height+right.height;
        pair.diameter=Math.max(currDiameter,pair.diameter);
        pair.diameter=Math.max(Math.max(left.diameter,right.diameter),pair.diameter);
        return pair;
    }
    public static void main(String[] args){
        Integer[] nums={1,2,4,null,null,5,null,null,3,null,null};
        TreeNode root=buildTree(nums);
        display(root);
        Pair pair=diameter(root);
        System.out.println("Diameter >>"+pair.diameter);
    }
}
