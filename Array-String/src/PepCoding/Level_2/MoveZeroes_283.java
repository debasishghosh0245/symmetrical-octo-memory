import java.util.*;
public class MoveZeroes_283{

    public static void main(String[] args){
        int[] nums={0,1,0,3,12};
        movesZeroII(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] movesZero(int[] nums){
        int n=nums.length;
        int[] ans=new int[nums.length];
        int j=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                ans[j++]=nums[i];
            }
        }
        return ans;
    }

    public static void movesZeroII(int[] nums){
        int numsOfZero=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                numsOfZero++;
            }
            else if(numsOfZero>0){
                int temp=nums[i];
                nums[i]=0;
                nums[i-numsOfZero]=temp;
            }
        }
    }
}
