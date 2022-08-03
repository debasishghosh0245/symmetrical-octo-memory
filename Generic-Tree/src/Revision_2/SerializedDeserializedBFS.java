import java.util.*;
public class SerializedDeserializedBFS{
    public static class TreeNode{
        int val;
        List<TreeNode> children=new ArrayList<>();
        TreeNode(int val){
            this.val=val;
        }
        TreeNode(int val,List<TreeNode> children){
            this.val=val;
            this.children=children;
        }
    }
    static int idx=0;
    public static TreeNode buildTreeDFS(Integer[] nums){
        if(idx==nums.length) return null;
        TreeNode root=new TreeNode(nums[idx++]);
        while(null!=nums[idx]){
            root.children.add(buildTreeDFS(nums));
            idx++;
        }
        return root;
    }

    public static String serialized(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        StringBuilder sb=new StringBuilder();
        queue.offer(root);
        sb.append(root.val+" ");
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-->0){
                TreeNode topNode=queue.poll();
                if(topNode==null){
                    continue;
                }
                if(topNode.children.size()==0){
                    sb.append("null"+" ");
                    queue.offer(null);
                }
                for(TreeNode child: topNode.children){
                    sb.append(child.val+" ");
                    queue.offer(child);
                }
                sb.append("$"+" ");
            }

        }
        return sb.toString();
    }

    public static TreeNode desirialized(String[] nums){
        int idx=0;
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode root=new TreeNode(Integer.parseInt(nums[idx]));
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode topNode=queue.poll();
            //if(topNode==null) continue;
            idx++;
            while(!nums[idx].equals("$")){
                if(nums[idx].equals("null")){
                    //topNode.children.add(null);
                    //queue.offer(null);
                }else{
                    TreeNode child=new TreeNode(Integer.parseInt(nums[idx]));
                    topNode.children.add(child);
                    queue.offer(child);
                }
                idx++;
            }
        }
        return root;
    }

    public static void display(TreeNode root){
        if(root==null) return;
        StringBuilder sb=new StringBuilder();
        sb.append(root.val+" >> ");
        for(TreeNode child : root.children){
            sb.append(child.val+" ");
        }
        System.out.println(sb);
        for(TreeNode child: root.children){
            display(child);
        }
    }

    public static void main(String[] args){
        Integer[] nums={1,3,null,4,6,null,7,null,null,2,null,null};
        TreeNode root=buildTreeDFS(nums);
        display(root);
        String str=serialized(root);
        System.out.println("Serialized "+str);
        TreeNode root2=desirialized(str.split(" "));
        System.out.println("Root2 >>"+root2);
        display(root2);
    }
}
