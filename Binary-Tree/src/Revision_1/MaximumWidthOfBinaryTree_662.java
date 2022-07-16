import java.util.*;
public class MaximumWidthOfBinaryTree_662 {

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

    public static int idx=0;
    public static TreeNode buildTree(Integer[] nums){
        if(idx>nums.length) return null;
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
        sb.append(root.left==null ? "-" :root.left.val);
        sb.append(" < "+root.val+" > ");
        sb.append(root.right==null ? "-" :root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }

    public static class Pair{
        TreeNode node;
        int idx;
        Pair(TreeNode node,int idx){
            this.idx=idx;
            this.node=node;
        }
    }

    //Time Compleixty  :
    //Space Complexity :
    public static int maxWidth(TreeNode root) {
        Queue<Pair> queue=new LinkedList<>();
        queue.offer(new Pair(root,0));
        int maxWidth=Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            int size=queue.size();
            int lefMostIdx=queue.peek().idx;
            int rightMostIdx=0;
            while(size-->0){
                Pair pair=queue.poll();
                TreeNode currNode=pair.node;
                int currIdx=pair.idx;
                rightMostIdx=currIdx;
                if(currNode.left!=null){
                    queue.offer(new Pair(currNode.left,2*currIdx+1));
                }
                if(currNode.right!=null){
                    queue.offer(new Pair(currNode.right,2*currIdx+2));
                }
            }
            maxWidth=Math.max(maxWidth,(rightMostIdx-lefMostIdx)+1);
        }
        return maxWidth;
    }

    public static void main(String[] args){
        Integer[] nums={1,3,5,null,null,3,null,null,2,null,9,null,null};
        //Integer[] nums={1,3,5,6,null,null,null,null,2,null,9,7,null,null,null};
        TreeNode root=buildTree(nums);
        display(root);
        System.out.println(maxWidth(root));
    }
}
