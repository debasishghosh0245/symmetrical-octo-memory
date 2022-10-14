import java.util.*;
public class WiggleSortII_324{

    public static void main(String[] args){
        //int[] nums={1,5,1,1,6,4};
        //int[] nums={5,5,5,4,4,4,4};
        int[] nums={1,3,2,2,3,1};
        wiggleSort(nums);
    }
    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int[] ans=new int[nums.length];
        int j=1;
        int i=nums.length-1;
        while(i>=0 && j < nums.length){
            ans[j]=nums[i];
            j=j+2;
            i--;
        }
        j=0;
        while(i>=0 && j < nums.length){
            ans[j]=nums[i];
            j=j+2;
            i--;
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=ans[i];
        }
        System.out.println(Arrays.toString(ans));
    }
}
