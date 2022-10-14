import java.util.*;
public class RecoverBinarySearchTree_990{
    TreeNode root;
    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val){
            this.val=val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.left=left;
            this.right=right;
            this.val=val;
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
        sb.append(root.left==null ? "-" :root.left.val);
        sb.append(" < "+root.val+" > ");
        sb.append(root.right==null ? "-" : root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }
    static TreeNode xNode=null;
    static TreeNode yNode=null;
    static TreeNode prevNode=null;
    public static void inorderTraversal(TreeNode root){
        if(root==null) return;
        inorderTraversal(root.left);
        if(null!=prevNode && root.val<prevNode.val){
            yNode=root;
            if(xNode==null){
                xNode=prevNode;
            }else{
                return;
            }
        }
        prevNode=root;
        inorderTraversal(root.right);
    }
    public static void swapNode(TreeNode val1,TreeNode val2){
        int temp=val1.val;
        val1.val=val2.val;
        val2.val=temp;
    }
    public static void main(String[] args){
        Integer[] nums={50,75,12,null,null,30,null,37,null,null,25,67,60,null,null,null,87,null,null};
        //Integer[] nums={3,1,null,null,4,2,null,null,null};
        TreeNode root=buildTree(nums);
        inorderTraversal(root);
        swapNode(xNode,yNode);
        display(root);
    }
}
