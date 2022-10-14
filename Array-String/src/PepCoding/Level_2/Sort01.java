import java.util.*;
public class Sort01 {

    public static void main(String[] args){
        int[] arr={0,1,0,1,0};
        sort(arr);
    }

    public static void sort(int[] arr){
        int i=0;
        int j=0;
        while(i<arr.length){
            if(arr[i]==0){
                swap(i,j,arr);
                j++;
            }
            i++;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int i,int j,int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
