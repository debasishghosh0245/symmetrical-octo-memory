import java.util.*;
public class AddOneRowToTree_623{
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
        if(root==null) return;
        StringBuilder sb=new StringBuilder();
        sb.append(root.left==null ? "-" : root.left.val);
        sb.append(" < "+root.val+" > ");
        sb.append(root.right==null ? "-" : root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }
    public static TreeNode addOneRow(TreeNode root,int depth,int val){
        //edge Case
        if(depth==1){
            TreeNode newNode=new TreeNode(val);
            newNode.left=root;
            return newNode;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int currDepth=1;
        while(currDepth!=depth-1){
            int size=queue.size();
            System.out.println("Size >>"+size);
            while(size-->0){
                TreeNode topNode=queue.poll();
                if(topNode.left!=null){
                    queue.offer(topNode.left);
                }
                if(topNode.right!=null){
                    queue.offer(topNode.right);
                }
            }
            currDepth++;
        }
        System.out.println(queue.toString());
        while(!queue.isEmpty()){
            TreeNode topNode=queue.poll();
            TreeNode left=topNode.left;
            TreeNode right=topNode.right;
            topNode.left=new TreeNode(val);
            topNode.right=new TreeNode(val);
            topNode.left.left=left;
            topNode.right.right=right;
        }
        return root;
    }
    public static void main(String[] args){
        //Integer[] nums={4,2,3,null,null,1,null,null,6,5,null,null,null};
        Integer[] nums={4,2,3,null,null,1,null,null,null};
        TreeNode root=buildTree(nums);
        int val=1;
        int depth=3;
        //display(root);
        TreeNode node=addOneRow(root,depth,val);
        System.out.println("-----------");
        display(node);
    }
}
