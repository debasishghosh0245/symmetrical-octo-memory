import java.util.*;
public class ProductOfArrayExceptSelf_238{

    public static void main(String[] args){
        int[] nums={1,2,3,4};
        System.out.println(Arrays.toString(productOfArrayExceptSelf(nums)));
    }

    public static int[] productOfArrayExceptSelf(int[] nums){
        int[] ans=new int[nums.length];
        int[] right=new int[nums.length];
        int leftProduct=1,rightProduct=1;
        for(int i=nums.length-1;i>=0;i--){
            rightProduct*=nums[i];
            right[i]=rightProduct;
        }
        for(int i=0;i<nums.length;i++){
            if(i+1 < nums.length){
                ans[i]=right[i+1]*leftProduct;
            }
            else{
                ans[i]=1*leftProduct;
            }
            leftProduct*=nums[i];
        }
        return ans;
    }

}
