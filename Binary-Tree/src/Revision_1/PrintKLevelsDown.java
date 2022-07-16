import java.util.*;
public class PrintKLevelsDown{
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
    public static TreeNode construct(Integer[] nums){
        if(idx>=nums.length) return null;
        if(nums[idx]==null){
            idx++;
            return null;
        }
        TreeNode root=new TreeNode(nums[idx++]);
        root.left=construct(nums);
        root.right=construct(nums);
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

    public static void printKLevelDown(TreeNode root,int k){
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty() && k >= 0){
            int size=queue.size();
            while(size-->0){
                TreeNode currNode=queue.poll();
                if(k==0){
                    System.out.print(currNode.val+" ");
                }
                if(currNode.left!=null){
                    queue.offer(currNode.left);
                }
                if(currNode.right!=null){
                    queue.offer(currNode.right);
                }
            }
            k--;
        }
    }

    public static void main(String[] args){
        Integer[] nums={50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
        TreeNode root=construct(nums);
        display(root);
        printKLevelDown(root,3);
    }
}
