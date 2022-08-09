import java.util.*;
public class PopulatingNextRightPointersInEachNode_116{
    TreeNode root;
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;
        TreeNode(){
        }
        TreeNode(int val){
            this.val=val;
        }
        TreeNode(int val,TreeNode left,TreeNode right,TreeNode next){
            this.val=val;
            this.left=left;
            this.right=right;
            this.next=next;
        }
    }
    static int idx=0;
    public static TreeNode buildTree(Integer[] nums){
        if(idx >= nums.length) return null;
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
        sb.append(root.left==null ? "-" : root.left.val+" ");
        sb.append(" < "+root.val+" > ");
        sb.append(root.right==null ? "-" : root.right.val+" ");
        sb.append(root.next==null ? " next - " : " next >> "+root.next.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }
    public static void bfs(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            TreeNode temp=null;
            while(size-->0){
                TreeNode topNode=queue.poll();
                if(temp!=null){
                    temp.next=topNode;
                }
                temp=topNode;
                TreeNode left=topNode.left;
                TreeNode right=topNode.right;
                if(left!=null){
                    queue.offer(left);
                }
                if(right!=null){
                    queue.offer(right);
                }
            }
        }
    }
    public static void dfs(TreeNode root){
        if(root==null) return;
        dfs(root.left);
        dfs(root.right);
        TreeNode left=root.left;
        TreeNode right=root.right;
        if(left!=null){
            left.next=right;
            if(left.left!=null){
                left.left.next=left.right;
            }
            if(left.right!=null){
                left.right.next=right.left;
            }
            if(right.left!=null){
                right.left.next=right.right;
            }
            if(right.right!=null){
                right.right.next=null;
            }
        }
    }
    public static void main(String[] args){
        Integer[] nums={1,2,4,null,null,5,null,null,3,6,null,null,7,null,null};
        TreeNode root=buildTree(nums);
        bfs(root);
        display(root);
    }
}
