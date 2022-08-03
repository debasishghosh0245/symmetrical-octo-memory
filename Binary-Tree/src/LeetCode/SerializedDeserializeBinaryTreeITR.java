import java.util.*;
public class SerializedDeserializeBinaryTreeITR{

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
        TreeNode node;
        int state;
        Pair(TreeNode node,int state){
            this.node=node;
            this.state=state;
        }
        public String toString(){
            return "root >>"+node.val;
        }
    }

    public static TreeNode deserialized(Integer[] nums){
        Stack<Pair> stack=new Stack<>();
        int idx=0;
        TreeNode root=new TreeNode(nums[idx]);
        stack.push(new Pair(root,0));
        while(!stack.isEmpty()){
            Pair pair=stack.peek();
            TreeNode node=pair.node;
            int state=pair.state;
            stack.peek().state++;
            if(state==0){
                idx++;
                if(nums[idx]!=null){
                    TreeNode leftNode=new TreeNode(nums[idx]);
                    node.left=leftNode;
                    stack.push(new Pair(leftNode,0));
                }

            }
            else if(state==1){
                idx++;
                if(nums[idx]!=null){
                    TreeNode rightNode=new TreeNode(nums[idx]);
                    node.right=rightNode;
                    stack.push(new Pair(rightNode,0));
                }
            }
            else if(state==2){
                stack.pop();
            }
        }
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
        display(root);
    }
}
