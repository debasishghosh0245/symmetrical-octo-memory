import java.util.*;
public class RemoveDuplicatesFromSortedArrayII_80{

    public static void main(String[] args){
        //int[] nums={1,1,1,2,2,3};
        int[] nums={0,0,0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int i=0;
        int j=1;
        while(j<nums.length){
            while(j<nums.length && nums[i]==nums[j]){
                j++;
            }
            i+=2;
            System.out.println("i >> "+i+" j >> "+j);
            if(i<nums.length && j<nums.length){
                nums[i]=nums[j];
            }

        }
        System.out.println(Arrays.toString(nums));
        return i+1;
    }

}
