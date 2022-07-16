import java.util.*;
public class IsGraphCyclic_DFS{

    public static void main(String[] args){
        int[][] graph3={{0,1,10},{2,3,10},{4,5,10},{5,6,10},{4,6,10}};
        int vertices=7;
        boolean ans=false;
        List<List<Integer>> adjList=isGraphCyclic(graph3,vertices);
        boolean[] visited=new boolean[adjList.size()];
        for(int vtx=0;vtx<adjList.size();vtx++){
            if(visited[vtx]==false) {
                visited[vtx]=true;
                ans=isGraphCyclic(adjList,vtx,visited);
            }
        }
        System.out.println(ans);
    }

    public static List<List<Integer>> isGraphCyclic(int[][] graph,int vertices){
        List<List<Integer>> adjacencyList=new ArrayList<>();
        for(int v=0;v<vertices;v++){
            adjacencyList.add(new ArrayList<>());
        }
        for(int[] edges:graph){
            adjacencyList.get(edges[0]).add(edges[1]);
            adjacencyList.get(edges[1]).add(edges[0]);
        }
        // for(int i=0;i<adjacencyList.size();i++){
        //     System.out.println(" Source >> "+i+" neighbours >> "+adjacencyList.get(i));
        // }
        return adjacencyList;
    }


    public static boolean isGraphCyclic(List<List<Integer>> adjList,int src,boolean[] visited){
        Stack<int[]> stack=new Stack<>();
        stack.push(new int[]{src,-1});
        while(!stack.isEmpty()) {
            int[] arr=stack.pop();
            int curr=arr[0];
            int prev=arr[1];
            List<Integer> neighbours=adjList.get(curr);
            for(int nbr:neighbours){
                if(visited[nbr]==true){
                    if(nbr!=prev) {
                        return true;
                    }
                }
                else if(visited[nbr]==false){
                    visited[nbr]=true;
                    stack.push(new int[]{nbr,curr});
                }
            }
        }
        return false;
    }
}
