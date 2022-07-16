import java.util.*;
public class NonOverlappingIntervals_435{

    public static void main(String[] args){
        int[][] intervals={{1,2},{2,3},{3,4},{1,3}};
        //int[][] intervals={{1,2},{1,2},{1,2}};
        System.out.println(nonOverlappingIntervals(intervals));
    }
    public static int nonOverlappingIntervals(int[][] intervals){
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int[] lastInterval=intervals[0];
        int cnt=1;
        for(int i=1;i<intervals.length;i++){
            if(lastInterval[1]<=intervals[i][0]){
                cnt++;
                lastInterval=intervals[i];
            }
        }
        return intervals.length-cnt;
    }
}
