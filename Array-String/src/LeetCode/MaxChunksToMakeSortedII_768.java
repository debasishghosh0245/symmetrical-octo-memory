import java.util.*;
public class MaxChunksToMakeSortedII_768{
    public static void main(String[] args){
        int[] arr={2,1,3,4,4};
        System.out.println(maxChunks(arr));
    }

    public static int maxChunks(int[] arr){
        int[] leftMax=new int[arr.length];
        int[] rightMin=new int[arr.length];
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int count=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            max=Math.max(arr[i],max);
            leftMax[i]=max;
        }
        for(int i=n-1;i>=0;i--){
            min=Math.min(arr[i],min);
            rightMin[i]=min;
        }
        //
        // System.out.println("Left Max >>"+Arrays.toString(leftMax));
        // System.out.println("Right Min >>"+Arrays.toString(rightMin));
        for(int i=0;i<n-1;i++){
            if(rightMin[i+1]>=leftMax[i]){
                count++;
            }
        }
        return count;
    }
}
