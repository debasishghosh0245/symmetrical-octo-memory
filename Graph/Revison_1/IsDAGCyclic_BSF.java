import java.util.*;
public class IsDAGCyclic_BSF{

    public static void main(String[] args){
        // int[][] graph1={{0,1,10},{1,2,10},{2,3,10},
        // {0,3,10},{3,4,10},{4,5,10},{5,6,10},{4,6,10}};
        int[][] graph2={{0,1,10},{1,2,10},{2,3,10},{3,4,10},{4,5,10},{5,6,10}};
        //int[][] graph3={{0,1,10},{2,3,10},{4,5,10},{5,6,10},{4,6,10}};
        int vertices=7;
        List<List<Integer>> adjList=buildGraph(graph2,vertices);
        boolean[] visited=new boolean[vertices];
        boolean result=false;
        for(int v=0;v<adjList.size();v++){
            if(visited[v]==false){
                visited[v]=true;
                if(isGraphCyclic(adjList,visited,v)==true) {
                    result=true;
                }
            }
        }
        System.out.println(result);
    }

    public static List<List<Integer>> buildGraph(int[][] graph,int vertices){
        List<List<Integer>> adjacencyList=new ArrayList<>(vertices);
        for(int i=0;i<vertices;i++){
            adjacencyList.add(new ArrayList<>());
        }
        for(int[] edge:graph){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        for(int i=0;i<vertices;i++){
            System.out.println("Source >> "+i+" Vertices >> "+adjacencyList.get(i));
        }
        return adjacencyList;
    }

    public static boolean isGraphCyclic(List<List<Integer>> adjacencyList,boolean[] visited,int src){
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{src,-1});
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-->0){
                int[] removedPair=queue.poll();
                int curr=removedPair[0];
                int prev=removedPair[1];
                System.out.print(curr+" ");
                List<Integer> neighbours=adjacencyList.get(curr);
                for(int nbr:neighbours){
                    if(visited[nbr] && nbr!=prev) {
                        return true;
                    }
                    else if(visited[nbr]==false){
                        visited[nbr]=true;
                        queue.offer(new int[]{nbr,curr});
                    }

                }
            }
            System.out.println(" ");
        }
        return false;
    }
}
