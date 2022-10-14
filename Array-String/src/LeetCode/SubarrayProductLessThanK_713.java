public class SubarrayProductLessThanK_713{

    public static void main(String[] args){
        int[] nums={10,5,2,6};
        int k=100;
        System.out.println(numSubarrayProductLessThanK(nums,k));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int maxProduct=Integer.MIN_VALUE;
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            int currProduct=1;
            for(int j=i;j<nums.length;j++){
                currProduct=nums[j]*currProduct;
                if(currProduct < k) cnt++;
            }
        }
        return cnt;
    }
}
