import java.util.*;
public class PathSumII_113{
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
            return this.val+"";
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
        sb.append(root.right==null ? "-" :root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }
    public static void pathSum(TreeNode root,int targetSum,List<List<Integer>> result,
        List<Integer> list){
        if(root==null) return;
        //System.out.println("targetSum "+targetSum);
        if(root.left==null && root.right==null){
            if(root.val==targetSum) {
                list.add(root.val);
                System.out.println("List >>"+list);
                result.add(list);
            }
        }
        list.add(root.val);
        pathSum(root.left,targetSum-root.val,result,new ArrayList<>(list));
        list.remove(list.size()-1);
        list.add(root.val);
        pathSum(root.right,targetSum-root.val,result,new ArrayList<>(list));
        list.remove(list.size()-1);
    }
    public static void main(String[] args){
        Integer[] nums={5,4,11,7,null,null,2,null,null,null,8,13,null,null,4,5,null,null,1,null,null};
        TreeNode root=buildTree(nums);
        display(root);
        int targetSum=22;
        List<List<Integer>> result=new ArrayList<>();
        pathSum(root,targetSum,result,new ArrayList<>());
        System.out.println(result);
    }
}
