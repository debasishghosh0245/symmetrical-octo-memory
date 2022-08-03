import java.util.*;
public class FindLeavesOfBinaryTree_366{

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
        if(idx==nums.length) return  null;
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
    public static void findLeaves(TreeNode root,List<Integer> leafNodes) {
        if(root==null) return;
        if(root.left!=null && root.left.left==null && root.left.right==null){
            //left node is leaf node
            leafNodes.add(root.left.val);
            root.left=null;
        }
        if(root.right!=null && root.right.left==null && root.right.right==null){
            //right node is leaf node
            leafNodes.add(root.right.val);
            root.right=null;
        }
        findLeaves(root.left,leafNodes);
        findLeaves(root.right,leafNodes);
    }

    static HashMap<Integer,List<Integer>> map=new HashMap<>();
    static int maxHeight=Integer.MIN_VALUE;
    public static int findLeavesII(TreeNode root) {
        if(root==null) return -1;
        int left=findLeavesII(root.left);
        int right=findLeavesII(root.right);
        int currHeight=Math.max(left,right)+1;
        map.putIfAbsent(currHeight,new ArrayList<>());
        List<Integer> list=map.get(currHeight);
        list.add(root.val);
        map.put(currHeight,list);
        maxHeight=Math.max(maxHeight,currHeight);
        return currHeight;
    }

    public static void main(String[] args){
        Integer[] nums={1,2,4,null,null,5,null,null,3,null,null};
        TreeNode root=buildTree(nums);
        display(root);
        findLeavesII(root);
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<=maxHeight;i++){
            result.add(map.get(i));
        }
        System.out.println(result);
    }
}
