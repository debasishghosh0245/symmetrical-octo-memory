import java.util.*;
public class IsGraphBipartiteDFS_785{

    public static void main(String[] args){
        //int[][] graph={{1,2,3},{0,2},{0,1,3},{0,2}};
        //int[][] graph={{1,3},{0,2},{1,3},{0,2}};
        int[][] graph={{1,2,3},{0,3,4},{0,3},{0,1,2},{1}};
        //int[][] graph={{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}};
        System.out.println(isGraphBipartitie(graph));
    }

    public static boolean isGraphBipartitie(int[][] graph){
        int [] colored=new int[graph.length];
        for(int vertex=0;vertex<graph.length;vertex++){
            if(colored[vertex]==0){
                if(!isGraphBipartitie_DFS(graph,vertex,1,colored)) return false;
            }
        }
        return true;
    }

    public static boolean isGraphBipartitie_DFS(int[][] graph,int src,int color,int[] colored){
        colored[src]=color;
        int[] neighbours=graph[src];
        for(int nbr:neighbours){
            if(colored[nbr]!=0){
                if(colored[nbr]!=-color) return false;
            }else{
                if(!isGraphBipartitie_DFS(graph,nbr,-color,colored)) return false;
            }
        }
        return true;
    }
}
