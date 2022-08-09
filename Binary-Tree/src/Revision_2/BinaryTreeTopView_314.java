import java.util.*;
public class BinaryTreeTopView_314{
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
    public static class Pair{
        int idx;
        TreeNode node;
        Pair(int idx,TreeNode node){
            this.idx=idx;
            this.node=node;
        }
    }
    public static List<Integer> topView(TreeNode root){
        List<Integer> result=new ArrayList<>();
        Queue<Pair> queue=new LinkedList<>();
        TreeMap<Integer,List<Integer>> map=new TreeMap<>();
        queue.offer(new Pair(0,root));
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-->0){
                Pair pair=queue.poll();
                TreeNode topNode=pair.node;
                int idx=pair.idx;
                map.putIfAbsent(idx,new ArrayList<>());
                List<Integer> list=map.get(idx);
                list.add(topNode.val);
                map.put(idx,list);
                if(topNode.left!=null){
                    queue.offer(new Pair(idx-1,topNode.left));
                }
                if(topNode.right!=null){
                    queue.offer(new Pair(idx+1,topNode.right));
                }
            }
        }
        for(List<Integer> list : map.values()){
            result.add(list.get(0));
        }
        return result;
    }
    public static TreeNode buildTree(Integer[] nums){
        int idx=0;
        TreeNode root=new TreeNode(nums[idx]);
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode topNode=queue.poll();
            if(topNode==null) continue;
            if(nums[++idx]==null){
                topNode.left=null;
                queue.offer(null);
            }else{
                topNode.left=new TreeNode(nums[idx]);
                queue.offer(topNode.left);
            }
            if(nums[++idx]==null){
                topNode.right=null;
                queue.offer(null);
            }else{
                topNode.right=new TreeNode(nums[idx]);
                queue.offer(topNode.right);
            }
        }
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
    public static void main(String[] aargs){
        Integer[] nums={50,25,75,12,37,67,87,null,null,30,null,
        null,70,null,null,null,null,null,null};
        TreeNode root=buildTree(nums);
        //display(root);
        System.out.println(topView(root));
    }
}
