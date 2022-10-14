import java.util.*;
public class PartitionArrayIntoDisjointIntervals_915{
    public static void main(String[] args){
        //int[] nums={1,1,1,0,6,12};
        //int[] nums={5,0,3,8,6};
        //int[] nums={90,47,69,10,43,92,31,73,61,97};
        //int[] nums={1,1};
        System.out.println(partitionDisjoint(nums));
    }

    public static int partitionDisjoint(int[] nums) {
        //int[] left_max=new int[nums.length];
        int[] right_min=new int[nums.length];
        int currMax=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        // for(int i=0;i<nums.length;i++){
        //     max=Math.max(nums[i],max);
        //     left_max[i]=max;
        // }
        for(int i=nums.length-1;i>=0;i--){
            min=Math.min(nums[i],min);
            right_min[i]=min;
        }
        System.out.println("Min Right >> "+Arrays.toString(right_min));
        //System.out.println("Left Max >> "+Arrays.toString(left_max));
        for(int i=0;i<nums.length-1;i++){
            currMax=Math.max(nums[i],currMax);
            if(currMax <= right_min[i+1]) return i+1;
        }
        return nums.length;
    }

}
