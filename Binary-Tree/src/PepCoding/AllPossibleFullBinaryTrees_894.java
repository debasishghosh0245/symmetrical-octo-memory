import java.util.*;
public class AllPossibleFullBinaryTrees_894{
    public static class TreeNode {
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
        System.out.println(sb.toString());
        display(root.left);
        display(root.right);
    }

    public static void main(String[] args){
        int n=7;
        if(n%2==0){
            System.out.println(new ArrayList<TreeNode>());
        }else{
            List<TreeNode> ans=allPossibleFBST(1,7);
            for(TreeNode node: ans){
                display(node);
                System.out.println(" ");
            }
        }
    }

    //Recursive
    public static List<TreeNode> allPossibleFBST(int start,int end){
        if(start>end){
            List<TreeNode> nodes=new ArrayList<>();
            nodes.add(null);
            return nodes;
        }
        if(start==end) {
            List<TreeNode> nodes=new ArrayList<>();
            nodes.add(new TreeNode(start));
            return nodes;
        }
        List<TreeNode> ans=new ArrayList<>();
        for(int i=start;i<=end;i++){
            if(i%2==0){
                List<TreeNode> leftResult=allPossibleFBST(start,i-1);
                List<TreeNode> rightResult=allPossibleFBST(i+1,end);
                for(TreeNode left : leftResult){
                    for(TreeNode right: rightResult){
                        TreeNode root=new TreeNode(i);
                        root.left=left;
                        root.right=right;
                        ans.add(root);
                    }
                }
            }
        }
        return ans;
    }
}
