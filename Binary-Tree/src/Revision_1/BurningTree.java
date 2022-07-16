import java.util.*;
public class BurningTree_BFS{
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
            return " "+val+" ";
        }
    }
    public static int idx=0;
    public static TreeNode construct(Integer[] nums){
        if(idx>=nums.length) return null;
        if(nums[idx]==null){
            idx++;
            return null;
        }
        TreeNode root=new TreeNode(nums[idx++]);
        root.left=construct(nums);
        root.right=construct(nums);
        return root;
    }
    public static void display(TreeNode root){
        if(root==null) return;
        StringBuilder sb=new StringBuilder();
        sb.append(root.left==null ? "-" :root.left.val);
        sb.append(" < "+root.val+" > ");
        sb.append(root.right==null ? "-" :root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }

    public static void buildGraph(TreeNode root,HashMap<Integer,List<Integer>> graph){
        if(root==null) return;
        graph.putIfAbsent(root.val,new ArrayList<Integer>());
        if(root.left!=null){
            graph.get(root.val).add(root.left.val);
            graph.putIfAbsent(root.left.val,new ArrayList<Integer>());
            graph.get(root.left.val).add(root.val);
        }
        if(root.right!=null){
            graph.get(root.val).add(root.right.val);
            graph.putIfAbsent(root.right.val,new ArrayList<Integer>());
            graph.get(root.right.val).add(root.val);
        }
        buildGraph(root.left,graph);
        buildGraph(root.right,graph);
    }

    public static int burnTree(HashMap<Integer,List<Integer>> graph,
        int target,HashMap<Integer,Boolean> visited){
        Queue<Integer> queue=new ArrayDeque<>();
        queue.offer(target);
        int time=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-->0){
                int currNodeVal=queue.poll();
                List<Integer> neighbours=graph.get(currNodeVal);
                if(neighbours.size()>0){
                    for(Integer val:neighbours){
                        if(visited.getOrDefault(val,false)==false){
                            visited.put(val,true);
                            queue.offer(val);
                        }
                    }
                }
            }
            time++;
        }
        return time-1;
    }

    public static void main(String[] args){
        Integer[] nums={12,13,null,null,10,14,21,null,null,24,null,null,15,22,null,null,23,null,null};
        TreeNode root=construct(nums);
        //display(root);
        HashMap<Integer,List<Integer>> graph=new HashMap<>();
        buildGraph(root,graph);
        System.out.println(graph);
        HashMap<Integer,Boolean> visited=new HashMap<>();
        System.out.println(burnTree(graph,14,visited));
    }
}
