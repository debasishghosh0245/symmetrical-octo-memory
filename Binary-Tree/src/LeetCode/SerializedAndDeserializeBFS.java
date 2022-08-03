import java.util.*;
public class SerializedAndDeserializeBFS{
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
        public String toString(){
            return this.val+" ";
        }
    }

    static int idx=0;
    public static TreeNode buildTree(Integer[] nums){
        if(idx==nums.length){
            return null;
        }
        if(nums[idx]==null){
            idx++;
            return null;
        }
        TreeNode root=new TreeNode(nums[idx++]);
        root.left=buildTree(nums);
        root.right=buildTree(nums);
        return root;
    }

    public static TreeNode deserialized(String[] str){
        Queue<TreeNode> queue=new LinkedList<>();
        int idx=0;
        TreeNode root=new TreeNode(Integer.parseInt(str[idx]));
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode topNode=queue.poll();
            if(topNode==null){
                continue;
            }
            if(str[++idx].equals("null")){
                topNode.left=null;
                queue.offer(null);
            }else{
                TreeNode left=new TreeNode(Integer.parseInt(str[idx]));
                topNode.left=left;
                queue.offer(left);
            }
            if(str[++idx].equals("null")){
                topNode.right=null;
                queue.offer(null);
            }else{
                TreeNode right=new TreeNode(Integer.parseInt(str[idx]));
                topNode.right=right;
                queue.offer(right);
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
    public static String serialized(TreeNode root){
        StringBuilder sb=new StringBuilder();
        if(root==null) return sb.toString();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-->0){
                TreeNode topNode=queue.poll();
                if(topNode==null){
                    sb.append(null+" ");
                    continue;
                }
                sb.append(topNode.val+" ");
                queue.offer(topNode.left);
                queue.offer(topNode.right);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Integer[] nums={50,25,12,null,null,37,30,null,null,null,75,67,null,70,null,null,87,null,null};
        TreeNode root=buildTree(nums);
        display(root);
        String str=serialized(root);
        System.out.println("str >>"+str);
        TreeNode root2=deserialized(str.split(" "));
        display(root2);
    }
}
