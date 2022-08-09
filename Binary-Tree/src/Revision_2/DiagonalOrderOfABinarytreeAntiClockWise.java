import java.util.*;
public class DiagonalOrderOfABinarytreeAntiClockWise{
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
    public static ArrayList<ArrayList<Integer>> diagonalView(TreeNode root){
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            ArrayList<Integer> list=new ArrayList<>();
            while(size-->0){
                TreeNode topNode=queue.poll();
                while(null!=topNode){
                    list.add(topNode.val);
                    if(topNode.right!=null){
                        queue.offer(topNode.right);
                    }
                    topNode=topNode.left;
                }
            }
            result.add(list);
        }
        return result;
    }
    public static void main(String[] args){
        Integer[] nums={8,3,1,null,null,null,10,6,4,null,null,7,null,null,14,13,null,null,null};
        TreeNode root=buildTree(nums);
        System.out.println(diagonalView(root));
    }
}
