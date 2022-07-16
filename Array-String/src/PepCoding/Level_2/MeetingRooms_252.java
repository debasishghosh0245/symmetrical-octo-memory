import java.util.*;
public class MeetingRooms_252{

    public static void main(String[] args){
        //int[][] intervals={{1,3},{2,6},{8,10},{15,18}};
        //int[][] intervals={{1,4},{2,3}};
        int[][] intervals={{1,4},{4,5}};
        System.out.println(mergeIntervals(intervals));
    }
    public static boolean mergeIntervals(int[][] intervals){
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        Stack<int[]> stack=new Stack<>();
        for(int[] currInterval: intervals){
            if(!stack.isEmpty()){
                int[] lastInterval=stack.peek();
                if(lastInterval[1] <= currInterval[0]){
                    stack.pop();
                    stack.push(new int[]{lastInterval[0],Math.max(currInterval[1],lastInterval[1])});
                }else{
                    return false;
                }
            }else{
                stack.push(currInterval);
            }
        }
        return true;
    }
}
