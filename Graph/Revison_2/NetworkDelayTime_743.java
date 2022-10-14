import java.util.*;
public class NetworkDelayTime_743{
    public static void main(String[] args){
        //int[][] times={{1,2,1}};
        //int n=2;
        //int k=1;
        //int[][] times={{1,2,1}};
        //int n=2;
        //int k=2;
        int[][] times={{2,1,1},{2,3,1},{3,4,1}};
        int n=4;
        int k=2;
        // int[][] times={{1,2,1},{2,3,2},{1,3,4}};
        // int n=3;
        // int k=1;
        Map<Integer,List<Pair>> adjMap=networkDelayTime(times,n,k);
        System.out.println(adjMap);
        System.out.println(singleSortestPathDjikstra(adjMap,n,k));
    }

    public static class Pair implements Comparable<Pair> {
        int source;
        int travelTime;
        Pair(int source,int travelTime){
            this.source=source;
            this.travelTime=travelTime;
        }
        public String toString(){
            return this.source+" "+this.travelTime;
        }
        public int compareTo(Pair pair){
            return this.travelTime-pair.travelTime;
        }
    }

    public static Map<Integer,List<Pair>> networkDelayTime(int[][] times,int n,int k){
        Map<Integer,List<Pair>> adjMap=new HashMap<>();
        for(int[] time: times){
            int src=time[0];
            int dest=time[1];
            int travelTime=time[2];
            adjMap.putIfAbsent(src,new ArrayList<Pair>());
            List<Pair> list=adjMap.get(src);
            list.add(new Pair(dest,travelTime));
            adjMap.put(src,list);
        }
        return adjMap;
    }

    public static int singleSortestPathDjikstra(Map<Integer,List<Pair>> adjMap,
        int n,int k){
        PriorityQueue<Pair> minHeap=new PriorityQueue<>();
        minHeap.offer(new Pair(k,0));
        HashSet<Integer> visited=new HashSet<>();
        int totalTime=-1;
        while(!minHeap.isEmpty()){
            Pair pair=minHeap.poll();
            int src=pair.source;
            int travelTime=pair.travelTime;
            if(visited.contains(src)) {
                continue;
            } else{
                visited.add(src);
            }
            totalTime=Math.max(totalTime,travelTime);
            List<Pair> neighbours=adjMap.get(src);
            if(null!=neighbours){
                for(Pair nbrVertex: neighbours){
                    minHeap.offer(new Pair(nbrVertex.source,nbrVertex.travelTime+travelTime));
                }
            }
        }
        return visited.size()==n ? totalTime : -1;
    }
}
