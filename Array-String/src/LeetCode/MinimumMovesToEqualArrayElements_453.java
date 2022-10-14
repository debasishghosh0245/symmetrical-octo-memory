public class MinimumMovesToEqualArrayElements_453{

    public static void main(String[] args){
        //int[] nums={1,2,3};
        int[] nums={13,18,3,10,35,68,50,20,50};
        System.out.println(minMovesII(nums));
    }

    public static int minMoves(int[] nums){
        int count=0;
        while(true){
            int min_idx=0;
            int max_idx=nums.length-1;
            for(int i=0;i<nums.length;i++){
                if(nums[i]<nums[min_idx]){
                    min_idx=i;
                }
                if(nums[i]>nums[max_idx]){
                    max_idx=i;
                }
            }
            int diff=nums[max_idx]-nums[min_idx];
            if(diff==0) break;
            count+=diff;
            for(int i=0;i<nums.length;i++){
                if(max_idx!=i){
                    nums[i]+=diff;
                }
            }
        }
        return count;
    }

    public static int minMovesII(int[] nums){
        //moves=sum-min*n where n is the length of the array
        int min=nums[0];
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            min=Math.min(min,nums[i]);
            sum+=nums[i];
        }
        return sum-min*n;
    }
}
