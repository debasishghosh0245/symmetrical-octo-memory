import java.util.*;
public class NodeToRootPathBinaryTree{
    public static int idx=0;
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
    public static TreeNode construct(Integer[] nums){
        if(idx>=nums.length) return null;
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

    public static List<Integer> nodeToRootPath(TreeNode root,int target){
        if(root==null) return new ArrayList<>();
        if(root.val==target){
            List<Integer> list=new ArrayList<>();
            list.add(target);
            return list;
        }
        List<Integer> left=nodeToRootPath(root.left,target);
        List<Integer> right=nodeToRootPath(root.right,target);
        if(left.size() > 0){
            left.add(root.val);
            return left;
        }
        if(right.size() > 0 ){
            right.add(root.val);
            return right;
        }
        return new ArrayList<>();
    }

    public static void main(String[] args){
        Integer[] nums={3,5,6,null,null,2,7,null,null,4,null,null,1,0,null,null,8,null,null};
        TreeNode root=construct(nums);
        display(root);
        TreeNode target=root.left.right.right;
        System.out.println("Traget >>"+target.val);
        System.out.println(nodeToRootPath(root,target.val));
    }
}
