import java.util.*;
public class SerializeAndDeserializeNaryTree_ITR{
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

    public static TreeNode deserializedHelper(String[] arr){
        Stack<TreeNode> stack=new Stack<TreeNode>();
        for(String str:arr){
            if(str.equals("null") && stack.size()>1){
                TreeNode child=stack.pop();
                stack.peek().children.add(child);
            }else if(!str.equals("null")){
                stack.push(new TreeNode(Integer.parseInt(str)));
            }
        }
        return stack.pop();
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
        TreeNode root=deserializedHelper(str.split(" "));
        display(root);
        StringBuilder sb=new StringBuilder();
        serialized(root,sb);
        System.out.println(sb.toString());
    }
}
