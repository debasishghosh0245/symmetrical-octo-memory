import java.util.*;
public class KthSmallestElementInaBST_230 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
        TreeNode(TreeNode left,TreeNode right,int val){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
    public static int idx=0;
    public static TreeNode buildTree(Integer[] nums){
        if(idx>=nums.length){
            return null;
        }
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
        sb.append(root.left==null? "-": root.left.val);
        sb.append(" < "+root.val+" > ");
        sb.append(root.right==null? "-" :root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }

    //Appoach 1:
    //Time Complexity  : 
    //Space Comlextity :
    public static void kthSmallestElementInBST1(TreeNode root,List<Integer> list){
        if(root==null) return;
        kthSmallestElementInBST1(root.left,list);
        list.add(root.val);
        kthSmallestElementInBST1(root.right,list);
    }

    //Apporach 2 : STack
    //Time Complexity  :
    //Space Complextiy :
    public static void kthSmallestElementInBST2(TreeNode root,Stack<Integer> stack,int k){
        if(root==null || k==stack.size()) return;
        kthSmallestElementInBST2(root.left,stack,k);
        if(k>stack.size()){
            stack.push(root.val);
        }
        kthSmallestElementInBST2(root.right,stack,k);
    }

    public static void main(String[] args){
        Integer[] nums={3,1,null,2,null,null,4,null,null};
        //Integer[] nums={5,3,2,1,null,null,null,4,null,null,6,null,null};
        TreeNode root=buildTree(nums);
        display(root);
        int k=1;
        //List<Integer> list=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        kthSmallestElementInBST2(root,stack,k);
        System.out.println(stack.toString());
        System.out.println("Kth Smallest Element >> "+stack.peek());
    }
}
