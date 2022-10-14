import java.util.*;
public class CompleteBinaryTreeInserter_919{
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
        public String toString(){
            return this.val+" ";
        }
    }
    static class CBTInserter {
        Queue<TreeNode> queue;
        TreeNode root;
        CBTInserter(TreeNode root) {
            this.root=root;
        }
        public int insert(int val) {
            queue=new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                if(queue.peek().left==null || queue.peek().right==null) {
                    break;
                }
                TreeNode topNode=queue.poll();
                queue.offer(topNode.left);
                queue.offer(topNode.right);
            }
            //System.out.println(queue);
            int rootVal=0;
            while(!queue.isEmpty()){
                TreeNode topNode=queue.poll();
                if(topNode.left==null){
                    rootVal=topNode.val;
                    topNode.left=new TreeNode(val);
                    break;
                }
                if(topNode.right==null){
                    topNode.right=new TreeNode(val);
                    rootVal=topNode.val;
                    break;
                }
            }
            return rootVal;
        }
        public TreeNode get_root() {
            return root;
        }
    }
    static int idx=0;
    public static TreeNode buildTree(Integer[] nums){
        if(idx > nums.length) return null;
        if(nums[idx]==null ) {
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
    public static void main(String[] args){
        Integer[] nums={1,2,null,null,3,null,null};
        TreeNode root=buildTree(nums);
        CBTInserter cbtInserter=new CBTInserter(root);
        System.out.println(cbtInserter.insert(4));
        System.out.println(cbtInserter.insert(5));
        System.out.println(cbtInserter.insert(6));
        System.out.println(cbtInserter.insert(7));
        display(root);
    }
}
