import java.util.*;
public class AllPathsFromSourceToTarget_797{

    public static void main(String[] args){
        int[][] graph={{4,3,1},{3,2,4},{3},{4},{}};
        //int[][] graph={{1,2},{3},{3},{}};
        //boolean[] visited=new boolean[graph.length];
        List<List<Integer>> allPaths=new ArrayList<>();
        dfs_recursive(graph,0,4,allPaths,new ArrayList<>());
        System.out.println(allPaths);
        // /bfs_iterative(graph,0,4);
    }

    public static void dfs_recursive(int[][] graph,int src,int dest,List<List<Integer>> allpaths,List<Integer> pathSoFar){
        int[] neighbours=graph[src];
        if(src==dest){
            pathSoFar.add(src);
            allpaths.add(pathSoFar);
            return;
        }
        for(int neighhbour:neighbours){
                pathSoFar.add(src);
                dfs_recursive(graph,neighhbour,dest,allpaths,new ArrayList<>(pathSoFar));
                pathSoFar.remove(pathSoFar.size()-1);
            }
    }

    public static void dfs_iterative(int[][] graph,int src,int dest){
        Stack<Integer> stack=new Stack<Integer>();
        stack.push(src);
        for(!stack.isEmpty()){
            int vertex=stack.peek();
            System.out.println(vertext);

            stack.push()
        }


    }

    public static void bfs_iterative(int[][] graph,int src,int dest){
        Queue<Integer> queue=new LinkedList<>();
        boolean[] visited=new boolean[graph.length];
        queue.offer(src);
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-->0){
                int rmVertex=queue.remove();
                System.out.print(" "+rmVertex+" ");
                int[] neighbours=graph[rmVertex];
                for(int neighbour:neighbours){
                        queue.offer(neighbour);
                }
            }
            System.out.println("");
        }
    }
}
