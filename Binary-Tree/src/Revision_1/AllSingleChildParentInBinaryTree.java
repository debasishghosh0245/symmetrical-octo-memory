import java.util.*;
public class AllSingleChildParentInBinaryTree{

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
    public static TreeNode construct(Integer[] nums){
        if(idx>nums.length) return null;
        if(nums[idx]==null){
            idx++;
            return null;
        }
        TreeNode root=new TreeNode(nums[idx++]);
        root.left=construct(nums);
        root.right=construct(nums);
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

    public static void allSingleChildParent(TreeNode root,ArrayList<Integer> list){
        //base case
        if(root==null) return;
        //single child
        if(root.left==null && root.right!=null){
            list.add(root.val);
        }
        if(root.right==null && root.left!=null){
            list.add(root.val);
        }
        allSingleChildParent(root.left,list);
        allSingleChildParent(root.right,list);
    }

    public static void main(String[] args){
        Integer[] nums={2,3,7,null,null,null,5,8,null,null,6,null,null};
        TreeNode root=construct(nums);
        display(root);
        ArrayList<Integer> list=new ArrayList<>();
        allSingleChildParent(root,list);
        System.out.println("Single Childs >>"+list);
    }


}
