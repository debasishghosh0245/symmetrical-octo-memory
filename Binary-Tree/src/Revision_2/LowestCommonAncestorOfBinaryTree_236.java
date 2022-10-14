import java.util.*;
public class LowestCommonAncestorOfBinaryTree_236{
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
        public String toString(){
            return this.val+" ";
        }
    }
    static int idx=0;
    public static TreeNode buildTree(Integer[ ] nums){
        if(idx > nums.length) return null;
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
        sb.append(root.left==null ? "-" : root.left.val);
        sb.append(" < "+root.val+" > ");
        sb.append(root.right==null ? "-" : root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }
    public static List<TreeNode> nodeToRootPath(TreeNode root,int val){
        if(root==null) return new ArrayList<TreeNode>();
        if(root.val==val){
            List<TreeNode> list=new ArrayList<>();
            list.add(root);
            return list;
        }
        List<TreeNode> left=nodeToRootPath(root.left,val);
        if(left.size()>0) {
            left.add(root);
            return left;
        }
        List<TreeNode> right=nodeToRootPath(root.right,val);
        if(right.size()>0) {
            right.add(root);
            return right;
        }
        return new ArrayList<>();
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        List<TreeNode> path1=nodeToRootPath(root,p);
        List<TreeNode> path2=nodeToRootPath(root,q);
        int i=path1.size()-1;
        int j=path2.size()-1;
        while(i>=0 && j>=0 && path1.get(i)==path2.get(j)){
            i--;
            j--;
        }
        return path1.get(i+1);
    }
    public static void main(String[] args){
        Integer[] nums={3,5,6,null,null,2,7,null,null,4,null,null,1,0,null,null,8,null,null};
        TreeNode root=buildTree(nums);
        display(root);
        System.out.println(lowestCommonAncestor(root,7,4).val);
    }
}
