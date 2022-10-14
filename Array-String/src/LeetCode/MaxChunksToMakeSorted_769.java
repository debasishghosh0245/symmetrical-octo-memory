import java.util.*;
public class MaxChunksToMakeSorted_769{
    public static void main(String[] args){
        //int[] arr={4,3,2,1,0};
        //int[] arr={2,0,1};
        //int[] arr={1,0,2,3,4};
        int[] arr={1,2,0,3};
        System.out.println(maxChunksToSorted(arr));
    }

    public static int maxChunksToSorted(int[] arr) {
        int[] leftMax=new int[arr.length];
        int max=Integer.MIN_VALUE;
        int count=0;
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
            if(i==max){
                count++;
            }
        }
        return count;
    }

}
