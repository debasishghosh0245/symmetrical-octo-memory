import java.util.*;
public class DeleteNodesAndReturnForest_1110{
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
            return val+"";
        }
    }
    static int idx=0;
    public static TreeNode buildTree(Integer[] nums){
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
    static List<TreeNode> list=new ArrayList<>();
    public static TreeNode delNodes(TreeNode root,HashSet<Integer> to_delete) {
        if(root==null) return root;
        root.left=delNodes(root.left,to_delete);
        root.right=delNodes(root.right,to_delete);
        if(to_delete.contains(root.val)){
            delIdx++;
            if(null!=root.left){
                list.add(root.left);
            }
            if(null!=root.right){
                list.add(root.right);
            }
            return null;
        }
        return root;
    }
    public static void main(String[] args){
        Integer[] nums={1,2,4,null,null,5,null,null,3,6,null,null,7,null,null};
        //Integer[] nums={1,2,4,null,null,3,null,null,null};
        TreeNode root=buildTree(nums);
        int[] to_delete={3,5};
        HashSet<Integer> set=new HashSet<Integer>();
        for(int del:to_delete){
            set.add(del);
        }
        TreeNode forest=delNodes(root,set);
        if(!set.contains(forest.val)){
            list.add(forest);
        }
        for(TreeNode node: list){
            System.out.println("-------------");
            display(node);
        }
    }
}
