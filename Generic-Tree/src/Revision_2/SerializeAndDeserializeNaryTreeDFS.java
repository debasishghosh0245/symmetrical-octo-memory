import java.util.*;
public class SerializeAndDeserializeNaryTreeDFS{
    public static class TreeNode{
        int val;
        List<TreeNode> children=new ArrayList<>();
        TreeNode(int val){
            this.val=val;
        }
        public String toString(){
            return val+"";
        }
    }
    public static int idx=0;
    public static TreeNode deserializedHelper(String[] nums){
        if(idx==nums.length) return null;
        TreeNode root=new TreeNode(Integer.parseInt(nums[idx++]));
        while(!nums[idx].equals("null")){
            root.children.add(deserializedHelper(nums));
            idx++;
        }
        return root;
    }

    public static void serialized(TreeNode root,StringBuilder sb){
        sb.append(root.val+" ");
        for(TreeNode child: root.children){
            serialized(child,sb);
        }
        sb.append("null ");
    }

    public static void display(TreeNode root){
        if(root==null) return;
        System.out.println(root.val+" >> "+root.children);
        for(TreeNode child: root.children){
            display(child);
        }
    }

    public static void main(String[] args) {
        String str="1 3 5 null 6 null null 2 null 4 null null ";
        //[1,null,3,2,4,null,5,6]

        TreeNode root=deserializedHelper(str.split(" "));
        display(root);
        StringBuilder sb=new StringBuilder();
        serialized(root,sb);
        System.out.println(sb.toString());
    }
}
