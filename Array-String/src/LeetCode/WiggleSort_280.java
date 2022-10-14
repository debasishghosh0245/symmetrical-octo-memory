import java.util.*;
public class WiggleSort_280{

    public static void main(String[] args){
        //int[] nums={3,5,2,1,6,4};
        //int[] nums={6,6,5,6,3,8};
        //int[] nums={10,7,6,5,9,8};
        int[] nums={10,12,15,6,9,8,2,4,11};
        wiggleSort(nums);
    }

    public static void wiggleSort(int[] nums){
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                if(i+1 < nums.length && nums[i]>nums[i+1]){
                    swap(i,i+1,nums);
                }
            }
            else{
                if(i+1 < nums.length && nums[i]<nums[i+1]){
                    swap(i,i+1,nums);
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int i,int j,int[] arr){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
