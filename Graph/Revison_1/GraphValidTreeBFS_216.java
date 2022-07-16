import java.util.*;
public class GraphValidTreeBFS_216 {

    public static void main(String[] args){
        // int n=5;
        // int[][] edges={{0,1},{0,2},{0,3},{1,4}};
        int n = 5;
        int[][] edges={{0,1},{1,2},{2,3},{1,3},{1,4}};
        List<List<Integer>> adjList=buildAdjacencyList(edges,n);
        HashSet<Integer> visited=new HashSet<>();
        visited.add(0);
        boolean result=isValidTree_BFS(adjList,0,visited) && visited.size()==n;
        System.out.println(result);
    }
    //TC:O(N+E)+O(N+E)
    //SC:O(N+E)+O(N)+O(N)
    public static boolean isValidTree_BFS(List<List<Integer>> adjList,int src,HashSet<Integer> visited){
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{src,-1});
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-->0){
                int[] arr=queue.poll();
                int curr=arr[0];
                int prev=arr[1];
                List<Integer> neighbours=adjList.get(curr);
                for(int nbr:neighbours){
                    if(visited.contains(nbr)){
                        if(nbr!=prev) return false;
                        else continue;
                    }else{
                        visited.add(nbr);
                        queue.offer(new int[]{nbr,curr});
                    }
                }
            }
        }
        return true;
    }

    //Time Complexity: O(n+e)
    //O(n) for initializing n vertices
    //o(e) for iterating over and inserting E edge
    //Space Compleixyt: O(E+N);
    public static List<List<Integer>> buildAdjacencyList(int[][] edges,int n){
        List<List<Integer>> adjList=new ArrayList<>(n);
        for(int vertex=0;vertex<n;vertex++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        for(int vertex=0;vertex<n;vertex++){
            System.out.println(adjList.get(vertex));
        }
        return adjList;
    }

}
