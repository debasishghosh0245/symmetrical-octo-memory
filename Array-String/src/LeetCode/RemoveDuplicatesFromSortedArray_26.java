import java.util.*;
public class RemoveDuplicatesFromSortedArray_26{

    public static void main(String[] args){
        int[] nums={0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int i=0;
        int j=1;
        while(j<nums.length){
            while(j<nums.length && nums[i]==nums[j]){
                j++;
            }
            System.out.println("j >>"+j);
            if(j<nums.length){
                nums[++i]=nums[j];
            }
        }
        return i+1;
    }
}
