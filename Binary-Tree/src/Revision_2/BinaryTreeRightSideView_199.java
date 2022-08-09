import java.util.*;
public class BinaryTreeRightSideView_199{
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
        if(idx> nums.length) return null;
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
        sb.append(root.right==null ? "-" : root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }
    public static List<Integer> rightSideView(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            int rightMostVal=0;
            while(size-->0){
                TreeNode topNode=queue.poll();
                rightMostVal=topNode.val;
                if(topNode.left!=null){
                    queue.offer(topNode.left);
                }
                if(topNode.right!=null){
                    queue.offer(topNode.right);
                }
            }
            list.add(rightMostVal);
        }
        return list;
    }
    public static void main(String[] args){
        //Integer[] nums={1,2,null,5,null,null,3,null,4,null,null};
        Integer[] nums={50,25,12,null,null,37,30,null,null,null,75,67,null,70,null,null,87,null,null};
        TreeNode root=buildTree(nums);
        display(root);
        System.out.println(bfs(root));
    }
}
