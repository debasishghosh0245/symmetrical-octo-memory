import java.util.*;
public class ConstructBinaryTreeFromString_536{

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
    public static class WrappableInteger{
        int val;
        WrappableInteger(int val){
            this.val=val;
        }
        public int getValue(){
            return this.val;
        }
        public void increment(){
            this.val++;
        }
    }
    public static TreeNode buildTree(String[] arr,WrappableInteger idx){
        System.out.println(Arrays.toString(arr));
        if(idx.getValue()==arr.length) return null;
        if(arr[idx.getValue()]==null){
            idx.increment();
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(arr[idx.getValue()]));
        idx.increment();
        root.left=buildTree(arr,idx);
        root.right=buildTree(arr,idx);
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

    public static void main(String[] args){
        String str="4(2(3)(1))(6(5))";
        TreeNode root=buildTree(str.split("\\("),new WrappableInteger(0));
        display(root);
    }
}
