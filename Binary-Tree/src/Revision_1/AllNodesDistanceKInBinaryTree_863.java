import java.util.*;
public class AllNodesDistanceKInBinaryTree_863_BFS{

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

    //Convert Binary Tree as undirected graph
    public static HashMap<Integer,List<Integer>> buildGraph(TreeNode root, HashMap<Integer,List<Integer>> graph){
        if(root==null) return graph;
        graph.putIfAbsent(root.val,new ArrayList<>());
        if(root.left!=null){
            graph.get(root.val).add(root.left.val);
            graph.putIfAbsent(root.left.val,new ArrayList<>());
            graph.get(root.left.val).add(root.val);
        }
        if(root.right!=null){
            graph.get(root.val).add(root.right.val);
            graph.putIfAbsent(root.right.val,new ArrayList<>());
            graph.get(root.right.val).add(root.val);
        }
        buildGraph(root.left,graph);
        buildGraph(root.right,graph);
        return graph;
    }

    public static List<Integer> distanceKBSF(HashMap<Integer,List<Integer>> graph,int k,int src,
        HashMap<Integer,Boolean> visited){
        Queue<Integer> queue=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        queue.add(src);
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-->0){
                int currNodeVal=queue.remove();
                if(k==0){
                    list.add(currNodeVal);
                }
                List<Integer> edges=graph.get(currNodeVal);
                if(edges!=null){
                    for(int edge:edges){
                        if(visited.getOrDefault(edge,false)==false){
                            visited.put(edge,true);
                            queue.offer(edge);
                        }
                    }
                }
            }
            k--;
        }
        return list;
    }

    public static void main(String[] args){
        Integer[] nums={3,5,6,null,null,2,7,null,null,4,null,null,1,0,null,null,8,null,null};
        int k=1;
        TreeNode root=construct(nums);
        TreeNode target=root.left.right;
        distanceK(root,target,k);
    }
}
