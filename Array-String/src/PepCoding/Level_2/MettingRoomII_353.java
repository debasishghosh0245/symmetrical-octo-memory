import java.util.*;
public class MettingRoomII_353{

    public static void main(String[] args){
        //int[][] intervals={{0,30},{5,10},{15,20}};
        // int[][] intervals={{2,11},{6,16},{11,16}};
        int[][] intervals={{9,10},{4,9},{4,17}};
        int[][] result=mergeIntervals(intervals);
        for(int[] arr:result){
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(result.length);
    }
    public static int[][] mergeIntervals(int[][] intervals){
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<int[]> priorityQueue=new PriorityQueue<>((a,b)->a[1]-b[1]);
        for(int[] currInterval: intervals){
            if(!priorityQueue.isEmpty()){
                int[] lastInterval=priorityQueue.peek();
                System.out.println("Past Intervals "+Arrays.toString(lastInterval));
                if(lastInterval[1] <= currInterval[0]){
                    priorityQueue.poll();
                    priorityQueue.offer(new int[]{lastInterval[0],Math.max(currInterval[1],lastInterval[1])});
                }else{
                    priorityQueue.offer(currInterval);
                }
            }else{
                priorityQueue.offer(currInterval);
            }
        }
        int n=priorityQueue.size();
        int[][] ans=new int[n][2];
        for(int i=ans.length-1;i>=0;i--){
            ans[i]=priorityQueue.poll();
        }
        return ans;
    }
}
