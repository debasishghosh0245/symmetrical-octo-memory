import java.util.*;
public class InsertInterval_57{

    public static void main(String[] args){
        // int[][] intervals={{1,5},{7,9},{10,13},{16,19},{20,25}};
        // int[] newInterval={12,20};
        //int[][] intervals={{1,2},{3,5},{6,7},{8,10},{12,16}}; int[] newInterval={4,8};
        //int[][] intervals={{1,3},{6,9}}; int[] newInterval={2,5};
        //int[][] intervals={};
        //int[] newInterval={5,7};
        int[][] intervals={{1,5}};
        int[] newInterval={6,8};
        int[][] result=insertInterval(intervals,newInterval);
        for(int[] ans:result){
            System.out.println(Arrays.toString(ans));
        }
    }

    public static int[][] insertInterval(int[][] intervals,int[] newInterval){
        if(intervals.length==0 && newInterval.length>0) return new int[][]{{newInterval[0],newInterval[1]}};
        Stack<int[]> stack=new Stack<>();
        int i=0;
        for(i=0;i<intervals.length;i++){
            if(intervals[i][0]<newInterval[0]){
                stack.push(intervals[i]);
            }else{
                break;
            }
        }
        if(stack.size()==0){
            stack.push(newinterval);
        }
        while(i<intervals.length){
            int[] lastInterval=stack.peek();
            if(intervals[i][0]<=lastInterval[1]){
                stack.pop();
                stack.push(new int[]{Math.min(lastInterval[0],intervals[i][0]),Math.max(newInterval[1],intervals[i][1])});
            }
            else{
                stack.push(intervals[i]);
            }
            i++;
        }
        int[][] result=new int[stack.size()][2];
        for(int j=result.length-1;j>=0;j--) {
            result[j]=stack.pop();
        }
        return result;
    }
}
