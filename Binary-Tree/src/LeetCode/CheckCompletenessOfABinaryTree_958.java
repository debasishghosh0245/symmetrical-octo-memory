import java.util.*;
public class CheckCompletenessOfABinaryTree_958{
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
            return val+" ";
        }
    }
    public static int idx=0;
    public static TreeNode buildTree(Integer[] nums){
        if(nums.length==idx) return null;
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
        sb.append(root.right==null ? "-": root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }
    public static boolean isCompleteBinaryTree(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode topNode=queue.poll();
            if(topNode.left==null && topNode.right!=null){
                return false;
            }
            if(topNode.right==null) {
                break;
            }
            queue.offer(topNode.left);
            queue.offer(topNode.right);
        }
        while(!queue.isEmpty()){
            TreeNode topNode=queue.poll();
            if(topNode.left!=null || topNode.right!=null) return false;
        }
        return true;
    }

    public static void main(String[] args){
        //Integer[] nums={1,2,4,null,null,5,null,null,3,6,null,null};
        Integer[] nums={1,2,5,null,null,null,3,6,null,null,8,null,null};
        TreeNode root=buildTree(nums);
        display(root);
        System.out.println(isCompleteBinaryTree(root));
    }
}
