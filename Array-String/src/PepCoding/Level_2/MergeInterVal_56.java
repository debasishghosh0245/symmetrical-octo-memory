import java.util.*;
public class MergeInterVal_56 {
    public static void main(String[] args){
        //int[][] intervals={{1,3},{2,6},{8,10},{15,18}};
        int[][] intervals={{1,4},{2,3}};
        //int[][] intervals={{1,4},{4,5}};
        int[][] result=mergeIntervals(intervals);
        for(int[] arr:result){
            System.out.println(Arrays.toString(arr));
        }
    }
    public static int[][] mergeIntervals(int[][] intervals){
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        Stack<int[]> stack=new Stack<>();
        for(int[] currInterval: intervals){
            if(!stack.isEmpty()){
                int[] lastInterval=stack.peek();
                if(lastInterval[1] > currInterval[0]){
                    stack.pop();
                    stack.push(new int[]{lastInterval[0],Math.max(currInterval[1],lastInterval[1])});
                }else{
                    stack.push(currInterval);
                }
            }else{
                stack.push(currInterval);
            }
        }
        int n=stack.size();
        int[][] ans=new int[n][2];
        for(int i=ans.length-1;i>=0;i--){
            ans[i]=stack.pop();
        }
        return ans;
    }
}
