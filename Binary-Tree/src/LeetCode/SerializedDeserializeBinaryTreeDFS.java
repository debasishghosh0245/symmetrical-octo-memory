import java.util.*;
public class SerializedDeserializeBinaryTreeDFS{

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
    public static TreeNode deserialized(Integer[] nums){
        if(idx==nums.length) return null;
        if(nums[idx]==null){
            idx++;
            return null;
        }
        TreeNode root=new TreeNode(nums[idx++]);
        root.left=deserialized(nums);
        root.right=deserialized(nums);
        return root;
    }

    public static void display(TreeNode root){
        if(root==null) return;
        StringBuilder sb=new StringBuilder();
        sb.append(root.left==null ? "-":root.left.val);
        sb.append(" < "+root.val+" > ");
        sb.append(root.right==null ? "-": root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }

    public static void main(String[] args){
        Integer[] nums={50,25,12,null,null,37,30,null,null,null,75,67,null,
        70,null,null,87,null,null};
        TreeNode root=deserialized(nums);
        display(root);
    }
}
