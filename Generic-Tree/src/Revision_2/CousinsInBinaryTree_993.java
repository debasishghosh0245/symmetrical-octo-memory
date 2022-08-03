import java.util.*;
public class CousinsInBinaryTree_993{
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
        sb.append(root.left==null  ? "-" : root.left.val);
        sb.append(" < "+root.val+" > ");
        sb.append(root.right==null ? "-" : root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }
    static int idx=0;
    public static TreeNode buildTree(Integer[] nums){
        if(idx==nums.length) return null;
        if(nums[idx]==null){
            idx++;
            return null;
        }
        TreeNode root=new TreeNode(nums[idx++]);
        root.left=buildTree(nums);
        root.right=buildTree(nums);
        return root;
    }
    public static boolean isCousins(TreeNode root,int x,int y){
        boolean xTrue=false;
        boolean yTrue=false;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int nodeAtDepth=queue.size();
            xTrue=false;
            yTrue=false;
            while(nodeAtDepth-->0){
                TreeNode topNode=queue.poll();
                System.out.println("topNode >>"+topNode.val);
                if(topNode.val==x){
                    xTrue=true;
                }
                if(topNode.val==y){
                    yTrue=true;
                }
                if(topNode.left!=null && topNode.right!=null) {
                    if(topNode.left.val==x && topNode.right.val==y){
                        return false;
                    }
                    if(topNode.left.val==y && topNode.right.val==x){
                        return false;
                    }
                }
                if(topNode.left!=null){
                    queue.offer(topNode.left);
                }
                if(topNode.right!=null){
                    queue.offer(topNode.right);
                }
            }
            if(xTrue && yTrue) return true;
        }
        return false;
    }
    public static void main(String[] args){
        //Integer[] nums={1,2,null,4,null,null,3,null,5,null,null};
        Integer[] nums={1,2,4,null,null,null,3,null,null};
        TreeNode root=buildTree(nums);
        display(root);
        int x = 5;
        int y = 4;
        System.out.println(isCousins(root,x,y));
    }
}
