import java.util.*;
public class BinarySearchTreeIteratorII_173{

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
    public static TreeNode buildTree(Integer[] nums){
        if(idx>=nums.length) return null;
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
        display(root.left);
        StringBuilder sb=new StringBuilder();
        sb.append(root.left==null ? "-" : root.left.val);
        sb.append(" < "+root.val+" > ");
        sb.append(root.right==null ? "-" : root.right.val);
        System.out.println(sb);
        display(root.right);
    }

    public static class BSTIterator {
        public static Stack<TreeNode> stack=new Stack<>();
        public BSTIterator(){
        }
        public BSTIterator(TreeNode root) {
            leftmostInorder(root);
        }
        public void leftmostInorder(TreeNode node){
            while(node!=null){
                stack.push(node);
                node=node.left;
            }
        }
        public int next() {
            TreeNode topNode=stack.pop();
            leftmostInorder(topNode.right);
            return topNode.val;
        }
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    public static void main(String[] args){
        Integer[] nums={7,3,null,null,15,9,null,null,20,null,null};
        TreeNode root=buildTree(nums);
        display(root);
        BinarySearchTreeIteratorII_173.BSTIterator obj = new BinarySearchTreeIteratorII_173.BSTIterator(root);
        System.out.println("Next >> "+obj.next());
        System.out.println("Next >> "+obj.next());
        System.out.println("HashNext >> "+obj.hasNext());
        System.out.println("Next >> "+obj.next());
        System.out.println("next >> "+obj.next());
        System.out.println("HashNext >> "+obj.hasNext());
        System.out.println("next >> "+obj.next());
        System.out.println("HashNext >> "+obj.hasNext());
        //System.out.println("next >> "+obj.next());
    }
}
