import java.util.*;
public class GraphValidTreeDFS_216 {

    public static void main(String[] args){
        int n=5;
        int[][] edges={{0,1},{0,2},{0,3},{1,4}};
        //int n = 5;
        //int[][] edges={{0,1},{1,2},{2,3},{1,3},{1,4}};
        List<List<Integer>> adjList=buildAdjacencyList(edges,n);
        HashSet<Integer> visited=new HashSet<>();
        boolean result=isValidTree_DFS(adjList,0,visited,-1) && visited.size()==n;
        //System.out.println("visited >> "+visited);
        System.out.println(result);
    }
    //Time Complexity: O(n+e)
    //O(n) for initializing n vertices
    //o(e) for iterating over and inserting E edge
    //Space Compleixyt: O
    public static List<List<Integer>> buildAdjacencyList(int[][] edges,int n){
        List<List<Integer>> adjList=new ArrayList<>(n);
        for(int vertex=0;vertex<n;vertex++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        // for(int vertex=0;vertex<n;vertex++){
        //     System.out.println(adjList.get(vertex));
        // }
        return adjList;
    }

    public static boolean isValidTree_DFS(List<List<Integer>> adjList,int src,HashSet<Integer> visited,int prev){
        visited.add(src);
        List<Integer> neighbours=adjList.get(src);
        for(int nbr:neighbours){
            if(visited.contains(nbr)){
                if(nbr!=prev) return false;
                continue;
            }else{
                isValidTree_DFS(adjList,nbr,visited,src);
            }
        }
        return true;
    }
}
