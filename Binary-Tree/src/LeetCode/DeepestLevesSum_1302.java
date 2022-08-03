import java.util.*;
public class DeepestLevesSum_1302{

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
        if(idx>=nums.length) {
            return null;
        }
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
        sb.append(root.left==null ? "-": root.left.val);
        sb.append(" < "+root.val+" > ");
        sb.append(root.right==null ? "-":root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }

    public static int deepestLevelSum(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        List<List<Integer>> levelOrderList=new ArrayList<>();
        int sum=0;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> temp=new ArrayList<>();
            while(size-->0){
                TreeNode dequeuedNode=queue.poll();
                temp.add(dequeuedNode.val);
                if(dequeuedNode.left!=null){
                    queue.offer(dequeuedNode.left);
                }
                if(dequeuedNode.right!=null){
                    queue.offer(dequeuedNode.right);
                }
            }
            levelOrderList.add(temp);
        }
        for(int i:levelOrderList.get(levelOrderList.size()-1)){
            sum+=i;
        }
        return sum;
    }
    public static void main(String[] args){
        Integer[] nums={1,2,4,7,null,null,null,5,null,null,3,null,6,null,8,null,null};
        TreeNode root=construct(nums);
        display(root);
        //System.out.println(rightSideViweBFS(root));
        System.out.println(deepestLevelSum(root));
    }
}
