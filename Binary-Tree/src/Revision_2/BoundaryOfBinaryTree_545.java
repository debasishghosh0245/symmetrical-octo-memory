import java.util.*;
public class BoundaryOfBinaryTree_545{
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
        sb.append(" < "+root.val+" > ");
        sb.append(root.right==null ? "-" : root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }

    public static void leftBoundary(TreeNode root,List<Integer> list){
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        list.add(root.val);
        if(root.left!=null){
            leftBoundary(root.left,list);
        }else{
            leftBoundary(root.right,list);
        }
    }
    public static void rightBoundary(TreeNode root,List<Integer> list){
        if(root==null) return;
        //if this is leaf node return
        if(root.left==null && root.right==null) return;
        if(root.right!=null){
            rightBoundary(root.right,list);
        }else{
            rightBoundary(root.left,list);
        }
        list.add(root.val);
    }
    public static void leafNodes(TreeNode root,List<Integer> list){
        if(root==null) return;
        if(root.left==null && root.right==null){
            list.add(root.val);
        }
        leafNodes(root.left,list);
        leafNodes(root.right,list);
    }
    public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root.left==null && root.right==null){
            list.add(root.val);
        }
        leftBoundary(root.left,list);
        leafNodes(root,list);
        rightBoundary(root.right,list);
        return list;
    }
    public static void main(String[] args){
        Integer[] nums={1,2,4,null,null,5,7,null,null,8,null,null,3,6,9,null,null,10,null,null,null};
        //Integer[] nums={1,null,null};
        TreeNode root=buildTree(nums);
        display(root);
        System.out.println(boundaryOfBinaryTree(root));
    }
}
