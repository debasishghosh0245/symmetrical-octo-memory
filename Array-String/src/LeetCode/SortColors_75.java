import java.util.*;
public class SortColors_75{
    public static void main(String[] args){
        int[] nums={2,0,2,1,1,0};
        sortColor(nums);
    }
    public static void sortColor(int[] nums){
        int i=0;
        int j=0;
        int k=nums.length-1;
        while(i<=k){
            if(nums[i]==0){
                swap(i,j,nums);
                i++;
                j++;
            }
            else if(nums[i]==2){
                swap(i,k,nums);
                k--;
            }
            else{
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    public static void swap(int a,int b,int[] arr){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
