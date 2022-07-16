import java.util.*;
public class IsGraphBipartiteBFS_785{

    public static void main(String[] args){
        //int[][] graph={{1,2,3},{0,2},{0,1,3},{0,2}};
        int[][] graph={{1,3},{0,2},{1,3},{0,2}};
        //int[][] graph={{1},{0,3},{3},{1,2}};
        //int[][] graph={{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}};
        //int[][] graph={{1},{0,3},{3},{1,2}};
        //int[][] graph={{1,2,3},{0,3,4},{0,3},{0,1,2},{1}};
        System.out.println(isGraphBipartitie(graph));
    }

    public static boolean isGraphBipartitie(int[][] graph){
        int [] colored=new int[graph.length];
        for(int vertex=0;vertex<graph.length;vertex++){
            if(colored[vertex]==0){
                if(!isGraphBipartitie_BSF(graph,vertex,colored)) return false;
            }
        }
        return true;
    }

    public static boolean isGraphBipartitie_BSF(int[][] graph,int src,int[] colored){
       Queue<Integer> queue=new LinkedList<>();
       queue.offer(src);
       colored[src]=1;
       while(!queue.isEmpty()){
            int currVertex=queue.poll();
            int[] neighbours=graph[currVertex];
            System.out.println(Arrays.toString(neighbours));
            for(int nbrVertex:neighbours){
               if(colored[nbrVertex]==0) {
                    colored[nbrVertex]=-colored[currVertex];
                    queue.offer(nbrVertex);
               }
               else if(colored[nbrVertex]!=-colored[currVertex]) {
                    // System.out.println("Neighbour Vertex > "+nbrVertex+" Colored >> "+colored[nbrVertex]+
                    // " Colored Initiation >> "+-colored[currVertex]);
                    return false;
                }
               }
           }
       return true;
   }
}
