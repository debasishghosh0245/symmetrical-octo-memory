import java.util.*;
public class UniqueBinarySearchTreesII_95{
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
    public static void main(String[] args){
        int n=2;
        List<TreeNode> list=uniqueBST(1,n);
        for(TreeNode node: list){
            display(node);
            System.out.println("---------");
        }
    }

    public static List<TreeNode> uniqueBST(int left,int right){
        if(left>right) {
            List<TreeNode> list=new ArrayList<>();
            list.add(null);
            return list;
        }
        if(left==right){
            List<TreeNode> list=new ArrayList<>();
            list.add(new TreeNode(left));
            return list;
        }
        List<TreeNode> result=new ArrayList<>();
        for(int i=left;i<=right;i++){
            List<TreeNode> listOfTreeNodeLeft=uniqueBST(left,i-1);
            List<TreeNode> listOfTreeNodeRight=uniqueBST(i+1,right);
            TreeNode root=new TreeNode(i);
            for(TreeNode leftNode: listOfTreeNodeLeft){
                for(TreeNode rightRight: listOfTreeNodeRight){
                    root.left=leftNode;
                    root.right=rightRight;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
