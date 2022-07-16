import java.util.*;
public class UniqueBinarySearchTreesII_95{

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
        List<TreeNode> list=uniqueBinarySearchTree(1,3);
        for(TreeNode node:list){
            display(node);
            System.out.println(" ");
        }
    }

    public static List<TreeNode> uniqueBinarySearchTree(int start,int end){
        if(end<start){
            List<TreeNode> list=new ArrayList<>();
            list.add(null);
            return list;
        }
        if(end==start){
            List<TreeNode> list=new ArrayList<>();
            list.add(new TreeNode(start));
            return list;
        }
        List<TreeNode> left=null;
        List<TreeNode> right=null;
        List<TreeNode> ans=new ArrayList<>();
        for(int i=start;i<=end;i++){
            left=uniqueBinarySearchTree(start,i-1);
            right=uniqueBinarySearchTree(i+1,end);
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root=new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
