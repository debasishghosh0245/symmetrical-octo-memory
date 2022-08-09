import java.util.*;
public class BinaryTreeCameras_968{
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
    public static TreeNode buildTree(Integer[] nums){
        Queue<TreeNode> queue=new LinkedList<>();
        int idx=0;
        TreeNode root=new TreeNode(nums[idx]);
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode topNode=queue.poll();
            if(topNode==null) continue;
            if(nums[++idx]==null){
                topNode.left=null;
            }else{
                topNode.left=new TreeNode(nums[idx]);
            }
            if(nums[++idx]==null){
                topNode.right=null;
            }
            else{
                topNode.right=new TreeNode(nums[idx]);
            }
            queue.offer(topNode.left);
            queue.offer(topNode.right);
        }
        return root;
    }

    public static void display(TreeNode root){
        if(root==null) return;
        StringBuilder sb=new StringBuilder();
        sb.append(root.left==null ? "-" :root.left.val);
        sb.append(" < "+root.val+" > ");
        sb.append(root.right==null ? "-":root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }
    static int count=0;
    public static int minCameraCover(TreeNode root) {
        if(root==null) return 1;
        if(root.left==null && root.right==null){
            return -1;
        }
        int left=minCameraCover(root.left);
        int right=minCameraCover(root.right);
        if(left==-1 || right==-1) {
            count++;
            return 1;
        }
        if(left==1 && right==1) return 0;
        if(left==0 || right==0) {
            return -1;
        }
        return 0;
    }
    public static void main(String[] args){
        //Integer[] nums={0,0,null,0,0,null,null,null,null};
        //Integer[] nums={0,0,null,0,null,0,null,null,0,null,null};
        Integer[] nums={0,0,null,null,0,0,null,null,0,0,null,null,null};
        TreeNode root=buildTree(nums);
        display(root);
        minCameraCover(root);
        System.out.println("Numbers of Cameras >"+count);
    }
}
