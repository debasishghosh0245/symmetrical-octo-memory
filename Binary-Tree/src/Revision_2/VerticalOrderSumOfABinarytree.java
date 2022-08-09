import java.util.*;
public class VerticalOrderSumOfABinarytree{
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
        if(root==null) return ;
        StringBuilder sb=new StringBuilder();
        sb.append(root.left==null ? "-" : root.left.val);
        sb.append(" < "+root.val+" > ");
        sb.append(root.right==null ? "-" :root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }
    public static class Pair{
        int idx;
        TreeNode node;
        Pair(int idx,TreeNode node){
            this.idx=idx;
            this.node=node;
        }
    }
    public static ArrayList<Integer> verticalOrderTraversal(TreeNode root){
        ArrayList<Integer> result=new ArrayList<>();
        Queue<Pair> queue=new LinkedList<>();
        queue.offer(new Pair(0,root));
        TreeMap<Integer,Integer> map=new TreeMap<>();
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-->0){
                Pair pair=queue.poll();
                TreeNode topNode=pair.node;
                int idx=pair.idx;
                map.put(idx,map.getOrDefault(idx,0)+topNode.val);
                if(topNode.left!=null){
                    queue.offer(new Pair(idx-1,topNode.left));
                }
                if(topNode.right!=null){
                    queue.offer(new Pair(idx+1,topNode.right));
                }
            }
        }
        for(int sum: map.values()){
            result.add(sum);
        }
        return result;
    }
    public static void main(String[] args){
        Integer[] nums={1,2,4,null,null,5,null,null,3,6,null,null,7,null,null};
        TreeNode root=buildTree(nums);
        //display(root);
        System.out.println(verticalOrderTraversal(root));
    }
}
