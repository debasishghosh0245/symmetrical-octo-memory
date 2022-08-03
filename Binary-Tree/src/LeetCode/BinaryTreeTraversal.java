import java.util.*;
public class BinaryTreeTraversal{

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
    public static TreeNode deserialized(Integer[] nums){
        if(idx==nums.length) return null;
        if(nums[idx]==null){
            idx++;
            return null;
        }
        TreeNode root=new TreeNode(nums[idx++]);
        root.left=deserialized(nums);
        root.right=deserialized(nums);
        return root;
    }
    public static void display(TreeNode root){
        if(root==null) return;
        StringBuilder sb=new StringBuilder();
        sb.append(root.left==null ? "-":root.left.val);
        sb.append(" < "+root.val+" > ");
        sb.append(root.right==null ? "-": root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }
    public static void main(String[] args){
        Integer[] nums={50,25,12,null,null,37,30,null,null,null,75,67,null,
        70,null,null,87,null,null};
        TreeNode root=deserialized(nums);
        //display(root);
        traversal(root);
    }

    public static class Pair{
        TreeNode node;
        int state;
        Pair(TreeNode node,int state){
            this.node=node;
            this.state=state;
        }
        public String toString(){
            return "node value >> "+node.val+" state >> "+state;
        }
    }

    public static void traversal(TreeNode root){
        Stack<Pair> stack=new Stack<>();
        stack.push(new Pair(root,1));
        StringBuilder preorder=new StringBuilder();
        StringBuilder postorder=new StringBuilder();
        StringBuilder inorder=new StringBuilder();
        while(!stack.isEmpty()){
            Pair pair=stack.peek();
            TreeNode node=pair.node;
            int state=pair.state;
            if(state==1){
                preorder.append(node.val+" ");
                if(node.left==null){
                    stack.peek().state++;
                }
                else{
                    stack.push(new Pair(node.left,1));
                }
            }
            else if(state==2){
                inorder.append(node.val+" ");
                if(node.right==null){
                    stack.peek().state++;
                }else{
                    stack.push(new Pair(node.right,1));
                }
            }
            else if(state==3){
                postorder.append(stack.pop().node.val+" ");
                if(!stack.isEmpty()){
                    stack.peek().state++;
                }
            }
        }
        System.out.println("preoreder >>"+preorder);
        System.out.println("inorder >>"+inorder);
        System.out.println("postorder >>"+postorder);
    }
}
