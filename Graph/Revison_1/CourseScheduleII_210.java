import java.util.*;
public class CourseScheduleII_210{

    public static void main(String[] args){
        int numCourses=4;
        int[][] prerequisites={{1,0},{2,0},{3,1},{3,2}};
        int[] indegree=new int[numCourses];
        //Map<Integer,List<Integer>> graph=buildGraph(numCourses,prerequisites,indegree);
        topologicalSort_II(prerequisites,indegree);
    }

    //for the directed graph we don't need to build graph
    //but for simplicity and readibility i am creating this
    //i will removed later
    public static Map<Integer,List<Integer>> buildGraph(int numCourses,int[][] prerequisites,
        int[] indegree){
        HashMap<Integer,List<Integer>> graph=new HashMap<>();
        for(int[] prerequisite : prerequisites){
            graph.putIfAbsent(prerequisite[1],new ArrayList<>());
            List<Integer> list=graph.get(prerequisite[1]);
            list.add(prerequisite[0]);
            graph.put(prerequisite[1],list);
            indegree[prerequisite[0]]++;
        }
        for(Map.Entry<Integer,List<Integer>> entry:graph.entrySet()){
            System.out.println(entry.getKey()+"  "+entry.getValue());
        }
        System.out.println("indegree >> "+Arrays.toString(indegree));
        return graph;
    }
    //using adjacency list
    public static void topologicalSort(int[] indegree,Map<Integer,List<Integer>> graph){
        Queue<Integer> queue=new LinkedList<>();
        for(int i: indegree){
            if(i==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int removedVertex=queue.poll();
            System.out.println(removedVertex);
            List<Integer> neighbours=graph.get(removedVertex);
            if(null!=neighbours && neighbours.size()>0){
                for(int nbr:neighbours){
                    indegree[nbr]--;
                    if(indegree[nbr]==0){
                        queue.offer(nbr);
                    }
                }
            }
        }
    }
    //without adjacencylist
    public static void topologicalSort_II(int[][] prerequisites,int[] indegree){
        //build indegree array//
        for(int[] prerequisite: prerequisites){
            indegree[prerequisite[0]]++;
        }
        //System.out.println("indegree.."+Arrays.toString(indegree));
        //Process BFS
        Queue<Integer> queue=new LinkedList<>();
        for(int i: indegree){
            if(i==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int removedVertex=queue.poll();
            System.out.println("Removed Vertex >> "+removedVertex);
            for(int[] prerequisite: prerequisites){
                if(prerequisite[1]==removedVertex){
                    indegree[prerequisite[0]]--;
                    //System.out.println("indegeree >> "+Arrays.toString(indegree));
                    if(indegree[prerequisite[0]]==0){
                        //System.out.println("prerequ >> "+prerequisite[0]);
                        queue.offer(prerequisite[0]);
                    }
                }
            }
            //System.out.println("Queue >> "+queue);
        }
    }
}
