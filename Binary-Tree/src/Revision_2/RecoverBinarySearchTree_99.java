import java.util.*;
public class RecoverBinarySearchTree_99{
    TreeNode root;
    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val){
            this.val=val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.left=left;
            this.right=right;
            this.val=val;
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
        sb.append(root.left==null ? "-" :root.left.val);
        sb.append(" < "+root.val+" > ");
        sb.append(root.right==null ? "-" : root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }
    public static void inorderTraversal(TreeNode root,List<Integer> inorderList){
        if(root==null) return;
        inorderTraversal(root.left,inorderList);
        inorderList.add(root.val);
        inorderTraversal(root.right,inorderList);
    }
    public static int[] sortAlmostSortedList(List<Integer> inorderList){
        int[] result=new int[2];
        boolean first_occurrence=false;
        for(int i=0;i<inorderList.size()-1;i++){
            if(inorderList.get(i)>inorderList.get(i+1)){
                result[0]=inorderList.get(i+1);
                if(!first_occurrence) {
                    result[1]=inorderList.get(i);
                    first_occurrence=true;
                }else{
                    break;
                }
            }
        }
        return result;
    }
    public static void swapTreeNode(TreeNode root,int val1,int val2){
        if(root==null) return;
        if(root.val==val1 || root.val==val2){
            if(root.val==val2){
                root.val=val1;
            }else{
                root.val=val2;
            }
        }
        swapTreeNode(root.left,val1,val2);
        swapTreeNode(root.right,val1,val2);
    }
    public static void main(String[] args){
        Integer[] nums={50,75,12,null,null,30,null,37,null,null,25,67,60,null,null,null,87,null,null};
        //Integer[] nums={3,1,null,null,4,2,null,null,null};
        TreeNode root=buildTree(nums);
        display(root);
        List<Integer> inorderlist=new ArrayList<>();
        inorderTraversal(root,inorderlist);
        System.out.println(inorderlist);
        int[] swaped=sortAlmostSortedList(inorderlist);
        System.out.println("After swap >> "+Arrays.toString(swaped));
        swapTreeNode(root,75,25);
        display(root);
    }
}
