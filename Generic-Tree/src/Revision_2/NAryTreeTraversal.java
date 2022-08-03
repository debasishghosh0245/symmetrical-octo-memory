import java.util.*;
public class NAryTreeTraversal{

    public static class TreeNode{
        int val;
        List<TreeNode> children=new ArrayList<>();
        TreeNode(int val){
            this.val=val;
        }
        TreeNode(int val,ArrayList<TreeNode> children){
            this.val=val;
            this.children=children;
        }
        public String toString(){
            return this.val+" ";
        }
    }
    static int idx=0;
    public static TreeNode buildTree(Integer[] nums){
        if(idx==nums.length) return null;
        TreeNode root=new TreeNode(nums[idx++]);
        while(nums[idx]!=null){
            root.children.add(buildTree(nums));
            idx++;
        }
        return root;
    }
    public static void display(TreeNode root){
        if(root==null) return;
        System.out.print(root.val+" >> ");
        for(TreeNode child: root.children){
            System.out.print(child.val+" ");
        }
        System.out.println("");
        for(TreeNode child: root.children){
            display(child);
        }
    }

    public static class Pair{
        TreeNode node;
        int idx;
        Pair(TreeNode node,int idx){
            this.node=node;
            this.idx=idx;
        }
        public String toString(){
            return "node >> "+this.node.val+" index >>  "+this.idx;
        }
    }


    public static List<Integer> traversal(TreeNode root){
        List<Integer> preOrder=new ArrayList<Integer>();
        preOrder.add(root.val);
        List<Integer> postOrder=new ArrayList<Integer>();
        Stack<Pair> stack=new Stack<>();
        stack.push(new Pair(root,0));
        while(!stack.isEmpty()){
            Pair pair=stack.peek();
            TreeNode topNode=pair.node;
            int idx=pair.idx;
            stack.peek().idx++;
            if(idx>=topNode.children.size()){
                if(!stack.isEmpty()){
                    postOrder.add(stack.pop().node.val);
                }
            }
            else{
                TreeNode child=topNode.children.get(idx);
                if(child!=null){
                    preOrder.add(child.val);
                    stack.push(new Pair(child,0));
                }
            }
        }
        return preOrder;
    }

    public static List<List<Integer>> levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> list=new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> tempList=new ArrayList<>();
            while(size-->0){
                TreeNode topNode=queue.poll();
                tempList.add(topNode.val);
                for(TreeNode child:topNode.children){
                    queue.offer(child);
                }
            }
            list.add(tempList);
        }
        return list;
    }

    public static void main(String[] args){
        Integer[] nums={1,3,5,null,6,null,null,2,null,4,null,null};
        TreeNode root=buildTree(nums);
        //display(root);
        System.out.println("print list >> "+traversal(root));
    }
}
