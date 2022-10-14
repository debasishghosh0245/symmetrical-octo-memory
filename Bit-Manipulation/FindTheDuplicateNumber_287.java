public class FindTheDuplicateNumber_287{

    public static void main(String[] args){
        int[] nums={3,1,3,2,4};
        System.out.println(findDuplicateNumber(nums));
    }

    public static int findDuplicateNumber(int[] nums){
        int duplicate=0;
        int n=nums.length-1;
        for(int bit=0;bit<32;bit++){
            int mask=1<<bit;
            int nums_count=0;
            int base_count=0;
            for(int i=0;i<=n;i++){
                if((nums[i] & mask)>0) {
                    nums_count++;
                }
                if((i & mask)>0){
                    base_count++;
                }
            }
            if(nums_count > base_count){
                    duplicate |= mask;
            }
        }
        return duplicate;
    }
}
