import java.util.*;
public class EvenOddTree_1609{
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
            return this.val+"";
        }
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
    static int idx=0;
    public static TreeNode buildTree(Integer[] nums){
        if(idx > nums.length) return null;
        if(nums[idx]==null) {
            idx++;
            return null;
        }
        TreeNode root=new TreeNode(nums[idx++]);
        root.left=buildTree(nums);
        root.right=buildTree(nums);
        return root;
    }

    public static boolean isEvenOddTreeBFS(TreeNode root){
        if(root.val%2==0) return false;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int level=0;
        while(!queue.isEmpty()){
            System.out.println("Queue >>"+queue.toString()+" Level "+level);
            int size=queue.size();
            while(size-->0){
                TreeNode topNode=queue.poll();
                System.out.println("topNode >> "+topNode.val+" Level "+level);
                //for even
                if(level%2==0){
                    if(topNode.val%2==0 || (size>0 && topNode.val >= queue.peek().val)){
                        //System.out.println("TopNode val >>"+topNode.val+" queue.peek() >> "+queue.peek().val);
                        return false;
                    }
                }else{
                    //for odd
                    if(topNode.val%2!=0 || (size>0 && topNode.val <= queue.peek().val)){
                        //System.out.println("TopNode val >>"+topNode.val+" queue.peek() >> "+queue.peek().val);
                        return false;
                    }
                }
                if(topNode.left!=null) {
                    queue.offer(topNode.left);
                }
                if(topNode.right!=null){
                    queue.offer(topNode.right);
                }
            }
            level++;
        }
        return true;
    }
    public static void main(String[] args){
        Integer[] nums={11,18,3,null,null,7,18,6,null,null,null,null,14,null,null};
        //Integer[] nums={5,4,3,null,null,3,null,null,2,7,null,null,null};
        //Integer[] nums={1,10,3,12,null,null,8,null,null,null,4,7,6,null,null,null,9,null,2,null,null};
        // Integer[] nums={11,8,1,30,17,null,null,null,20,null,null,3,18,null,null,16,null,null,6,9,12,null,null,
        // 10,null,null,11,4,null,null,2,null,null};
        // Integer[] nums={11,8,1,30,17,null,null,null,20,null,null,3,18,null,null,16,null,null,6,9,12,null,null,
        // 10,null,null,11,4,null,null,2,null,null};
        TreeNode root=buildTree(nums);
        display(root);
        System.out.println(isEvenOddTreeBFS(root));
    }
}
