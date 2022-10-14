import java.util.*;
public class MaximumProductOfThreeNumbers_628{

    public static void main(String[] args){
        //int[] nums={1,2,3,4};
        //int[] nums={-1,-2,-3};
        //int[] nums={-100,-98,-1,2,3,4};
        System.out.println(maximumProduct(nums));
    }

    public static int maximumProduct(int[] nums) {
        int max1=Integer.MIN_VALUE;
        int max2=max1;
        int max3=max2;

        int min1=Integer.MAX_VALUE;
        int min2=min1;

        for(int i=0;i<nums.length;i++){
            if(nums[i] > max1){
                max3=max2;
                max2=max1;
                max1=nums[i];
            }else if(nums[i] > max2){
                max3=max2;
                max2=nums[i];
            }
            else if(nums[i] > max3){
                max3=nums[i];
            }
            if(nums[i] < min1){
                min2=min1;
                min1=nums[i];
            }else if(nums[i] < min2){
                min2=nums[i];
            }
        }

        return Math.max(min1*min2*max1,max1*max2*max3);
    }
}
