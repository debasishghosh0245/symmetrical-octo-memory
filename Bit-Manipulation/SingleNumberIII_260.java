import java.util.*;
public class SingleNumberIII_260{

    public static void main(String[] args){
        int[] nums={1,2,1,3,2,5};
        System.out.println(Arrays.toString(singleNumber(nums)));
    }

    public static int[] singleNumber(int[] nums) {
        int[] result=new int[2];
        int c=0;// XOR of all nums
        for(int i=0;i<nums.length;i++){
            c=c^nums[i];
        }
        int rightSetBitMask=c & -c;
        int x=0;
        int y=0;
        for(int i=0;i<nums.length;i++){
            //group for zero
            if((nums[i] & rightSetBitMask)==0) {
                x=x ^ nums[i];
            }
            //group for one
            else{
                y=y ^ nums[i];
            }
        }
        result[0]=y;
        result[1]=x;
        return result;
   }
}
